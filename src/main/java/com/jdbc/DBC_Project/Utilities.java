package com.jdbc.DBC_Project;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Utilities { // Db Action alan JDBC method
    Connection connection = null; // sql query de göndermek icin db baglantisi yapacak olan obj
    Statement statement = null; // sql verilerinin resultunu return edecek obj
    PreparedStatement pstatement = null; // parametreli statement obj -> guven ve hiz icin

    private void  dBaseConnect(){
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Lafonten74.";
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void createDB(){
        dBaseConnect();
        try {
            String query = "create database if not exists telefon_rehberi";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            useTelRehberi();
            query="create table if not exists tel_nolar" +
                    "(id int primary key auto_increment," +
                    "isim varchar(50)," +
                    "tel varchar(15))";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            dBaseClosed();
        }

    }
    private void useTelRehberi() {

        String query = "use telefon_rehberi";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void dBaseClosed() {
        try {
           if(connection!=null){
               connection.close();
           }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public List<Record> listData(){
        List<Record> liste = new ArrayList<>();
        createDB();
        dBaseConnect();
        useTelRehberi();
        String query = "select * from tel_nolar";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Record record = new Record();
                record.setId(resultSet.getInt(1));
                record.setIsim(resultSet.getString(2));
                record.setTel(resultSet.getString(3));
                liste.add(record);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return liste;
    }

 public void addData(Record record){
        createDB();
        dBaseConnect();
        useTelRehberi();
        String query = "insert into tel_nolar (isim,tel) values(?,?)";
     try {
         pstatement = connection.prepareStatement(query);
         pstatement.setString(1,record.getIsim());
         pstatement.setString(2,record.getTel());
         pstatement.executeUpdate();
     } catch (SQLException e) {
         System.out.println(e.toString());
     }
     finally {
         dBaseClosed();
     }
 }
 public void updateData(Record record){
     createDB();
     dBaseConnect();
     useTelRehberi();
     String query = "update tel_nolar set isim=?,tel=? where id =?";
     try {
         pstatement= connection.prepareStatement(query);
         pstatement.setString(1,record.getIsim());
         pstatement.setString(2, record.getTel());
         pstatement.setInt(3,record.getId());
     } catch (SQLException e) {
         System.out.println(e.toString());
     }finally {
         dBaseClosed();
     }
 }

    public void deleteData(int id){
        createDB();
        dBaseConnect();
        useTelRehberi();
        String query="delete from tel_nolar where id=?";
        try {
            pstatement= connection.prepareStatement(query);
            pstatement.setInt(1,id);
            pstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            dBaseClosed();
        }
    }

}
