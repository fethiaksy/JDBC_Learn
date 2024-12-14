package com.jdbc.JDBC_Study;

import java.sql.*;
import java.util.Arrays;

public class J02_DML {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_fsae04","root","Lafonten74."); // database
        Statement statement = connection.createStatement(); // sql sorgularini calistirmak icin gerekli yani execute islemi
       // statement.execute("create table calisanlar (id int, isim VARCHAR(50), maas int)");
        System.out.println("***   task01 ****");

        System.out.println("   ***   task01   ***   ");
        // Task01-> Calisanlar tablosuna yeni bir kayit ((1005, 'Yıldız Hanım' , 33000)  ekleyelip kaydi teyit icin sorgulayınız.
       //  int s1= statement.executeUpdate("insert into calisanlar values (1005,'Yildiz Hanim',33000)");
       //  System.out.println("Yildiz hanim eklendi "+s1);
        ResultSet rs = statement.executeQuery("select * from calisanlar");
        while (rs.next()) {
            System.out.printf("%-6d%-20s%-6d\n", rs.getInt(1), rs.getString(2), rs.getInt(3));
        }
            System.out.println("   ***   task02   ***   ");
            // Task02-> Calisanlar tablosuna birden fazla yeni kayıt ekleyelim.
            // 1. yöntem
              //Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin yavas yapilmasina yol acar.
             // 10000 tane veri kaydi yapildigi dusunuldugunde  bu kotu bir yaklasimdir.
            /*
            String[] insertQuery ={
                    "insert into calisanlar values(1006,'Abdurrahman Bey','35000')",
                    "insert into calisanlar values(1007,'Zeynep Hanim','37000')",
                    "insert into calisanlar values(1008,'Fethi Bey','39000')",
                    "insert into calisanlar values(1009,'Selim Bey','41000')"
            };
            int insertSatirSayisi = 0;
            for (String avuc : insertQuery){
                insertSatirSayisi+=statement.executeUpdate(avuc);
            }
            System.out.println(" DB' ye "+insertSatirSayisi+ " veri eklendi.");
        */

        //2. Yöntem
        // addBatch() -> metodu ile SQL ifadeleri gruplandirilabilir ve exucuteBatch()  metodu ile veritabanina bir kere gonderilebilir.
        // ***!!!!**** excuteBatch() metodu bir int [] dizi dondurur ve  Bu dizi her bir ifade sonucunda etkilenen satir sayisini return eder.

        String[] insertQuery ={
                "insert into calisanlar values(1010,'Haluk Bey','45000')",
                "insert into calisanlar values(1011,'Aylin Hanim','47000')",
                "insert into calisanlar values(1012,'Faruk Bey','49000')",
                "insert into calisanlar values(1013,'Ali Bey','51000')"
        };
       for (String avuc : insertQuery){
           statement.addBatch(avuc);
       }
       int[] satir = statement.executeBatch();
        System.out.println("DB ye"+ Arrays.toString(satir)+" veri eklendi");


        }
    }

