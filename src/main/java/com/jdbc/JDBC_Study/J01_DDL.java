package com.jdbc.JDBC_Study;

import com.jdbc.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class J01_DDL  {
    /*
   A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
   dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.
   1) execute() metodu
   2) excuteUpdate() metodu.

   B)   - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
   - execute(), Boolean bir deger dondurur.
   - DDL islemlerin false dondururken, DML islemlerinde true deger dondurur.(ResultSet olusturur)
   - Ozellikle hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
   durumlarda tercih edilmektedir.

   C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
   -  bu islemlerde islemden etkilenen satir sayisini return eder.
   - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 return eder.

   execute() her turlu SQL kjomutuyla kullanilir .......  DDL ---> False    DML----> True
   executeUpdate()  DDL ----> 0           DML ----->etkilenen satir sayisini verir
              */
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_fsae04","root","Lafonten74."); // database
        Statement statement = connection.createStatement(); // sql sorgularini calistirmak icin gerekli yani execute islemi
        // System.out.println("   ***   task01   ***   ");
        // Task01-> markalar adında bir tablo oluşturunuz. marka_id int, marka_isim VARCHAR(15), calisan_sayisi int
       // String query="create table markalar (marka_id int, marka_isim VARCHAR(15), calisan_sayisi int)";
        // boolean s1=statement.execute(query);
        // System.out.println("Markalar tablosu create edildi."+statement.execute(query));
        // System.out.println("Markalar tablosu create edildi."+s1);
        // execute() --> Boolean deger dönderir DDL -> False, DML -> True deger döner

        // ikinci yontem
       // int s2 = statement.executeUpdate(query);
       // System.out.println("Markalar tablosu create edildi."+s2);//0

        // System.out.println("   ***   task02   ***   ");
        // Task02->  markalar tablosunu siliniz
        // String query1="drop table markalar";
        // System.out.println("Markalar tablosu silindi. "+statement.execute(query1));


        /* System.out.println("   ***   task03   ***   ");
        // Task03-> markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz.
        String alterQuery ="alter table markalar add column sube_sayisi int";
        boolean s1 = statement.execute(alterQuery);
            System.out.println("Markalar tablosuna sütun eklendi."+s1);
        */

        /*
        System.out.println("   ***   task04   ***   ");
        // Task04-> markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz, ancak bu sutunun yeri marka_id den sonra olsun
        System.out.println("Markalar tablosuna sube_sayisi_1 eklendi "
                +statement.execute("alter table markalar add column sube_sayisi_1 int after marka_id"));
        */

    }
}
