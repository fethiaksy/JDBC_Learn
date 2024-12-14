package com.jdbc.JDBC_Study;

import java.sql.*;

public class J02_ReadData02 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc_fsae04";
        String username = "root";
        String password = "root";
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_fsae04", "root", "Lafonten74."); //database baglantisi icin
         // Connection connection = DriverManager.getConnection(url, username, password); //database baglantisi icin

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//sql sorgu(query) calistirmak (execute etmek) icin
        // rs resultest'i cursoru scroll'a duyarsız sadece read yapma tanımlandı.
        // bu parametre statement'e tanımlanmzasa default olarak cursor-1 imleç iterator tanımlar...
        ResultSet rs = statement.executeQuery("select * from personel");


        System.out.println("   *** task01 ***     ");
        // task01-> ilk satırdaki ilk obj print eden code create ediniz.
       // int mevcutSatir = rs.getRow();
       // System.out.println("mevcutSatir = "+mevcutSatir);
        System.out.println("rs.first() = "+rs.first());
        System.out.println("rs.getObject(1) = "+rs.getObject(1));

        System.out.println("   *** task02 ***     ");
        // task02->ilk sutunun 5. değerini print eden code create ediniz-> 5.satırın ilk sutunundaki record
      //  int mevcutSatir = rs.getRow();
      //  System.out.println("mevcutSatir = " + mevcutSatir);
        rs.absolute(5);
        int mevcutSatir = rs.getRow();
     //   System.out.println("mevcutSatir = " + mevcutSatir);
//        System.out.println("rs.first() = "+rs.first());
        System.out.println("rs.getObject(1) = "+rs.getObject(1));

        System.out.println("   *** task03 ***     ");
        // task03->tum id listeyi print eden code create ediniz.
        rs.absolute(0);
        while (rs.next()){
            System.out.println("rs.getObject(1) = "+rs.getObject(1));

        }



        System.out.println("   *** task04 ***     ");
        // task04->tum isim listeyi print eden code create ediniz.
        rs.absolute(0);
        while (rs.next()) {
            System.out.println("rs.getObject(1) = " + rs.getObject("isim"));
        }


            System.out.println("   *** task05 ***     ");
        // task05->tum sehir listeyi print eden code create ediniz.
        rs.absolute(0);
        while (rs.next()) {
            System.out.println("rs.getObject(1) = " + rs.getObject("sehir"));
        }


        System.out.println("   *** task06 ***     ");
        // task06->tum maas listeyi print eden code create ediniz.
        rs.absolute(0);
        while (rs.next()) {
            System.out.println("rs.getObject(1) = " + rs.getObject("maas"));
        }

        System.out.println("   *** task07 ***     ");
        // task07->tum sirket listeyi print eden code create ediniz.
        rs.absolute(0);
        while (rs.next()) {
            System.out.println("rs.getObject(1) = " + rs.getObject("sirket"));
        }


        connection.close();
        statement.close();
        rs.close();
    }
}
