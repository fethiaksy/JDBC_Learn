package com.jdbc.JDBC_Study;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class J03_CRUD {
    /*
   Cok miktarda kayit eklemek icin PreparedStatement metodu kullanilabilir.
   PreparedStatement hem hizli hem de daha guvenli (SQL injection saldirilari icin) bir yontemdir.
   ResultSet tum sonucları bellekte tutuyor.. banka hesapları vs hassas datalar için  ama guvenli degil..
   bu yuzden database in guvenligi acisindan PreparedStatement tercih edilir..
   Bunun icin; Data insert'e uygun bir POJO(Plain Old Java Object) class'i obj ile datalar db'ye insert edilir.

   PreparedStatement : Statement interface'ini extend eder.
   Statement ile olusturdugumuz sorgu icin Db'de bellekte sorgunun bir örnegi olusturulur.
   Sorgu her calistirildiginda yeni bir örnegi olusturulur.
   PreparedStatement : Birden fazla kez calistirilabilen parametrelendirilmis SQL sorgularini temsil eder.
   PreparedStatement ile sorgu olusturudumuzda, bu sorgunun örnegi DB'de bellekte tutulur,
   sorgu her çalıştırıldığında aynı önceki örneği kullanılır.
*/
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_fsae04","root","Lafonten74."); // database
        Statement statement = connection.createStatement(); // sql sorgularini calistirmak icin gerekli yani execute islemi

        // Task-> Dersler adında bir tablo  create edip (id int, ders_isim varchar(15), egitim_suresi int)
        String query = "create table dersler(id int, ders_isim varchar(15), egitim_suresi_gun int)";
       // statement.execute(query);
        List<Ders> dersler = new ArrayList<>();
        dersler.add(new Ders(101,"Java",250));
        dersler.add(new Ders(102,"Matematik",100));
        dersler.add(new Ders(103,"Ingilizce",150));
        dersler.add(new Ders(104,"Fizik",200));
        dersler.add(new Ders(105,"Kimya",120));

        PreparedStatement table = connection.prepareStatement("insert into dersler values(?,?,?)");
        for (Ders avuc : dersler){
            table.setInt(1,avuc.getId());
            table.setString(2,avuc.getDers_isim());
            table.setInt(3,avuc.getEgitim_suresi_gun());
            table.addBatch();
        }
        table.executeBatch();
        System.out.println("Eger bu yaziyi okuyorsan islemin gerceklesti.");
    }
}
