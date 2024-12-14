package com.jdbc.JDBC_Study;

import java.sql.*;

public class J04_ReadData {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_fsae04","root","Lafonten74."); // database
        Statement statement = connection.createStatement(); // sql sorgularini calistirmak icin gerekli yani execute islemi

        System.out.println("   ***   task02   ***   ");
        // Task02-> talebeler table'daki notları 90 dan yuksek olan record'ları listeleyen code create ediniz
        ResultSet rs = statement.executeQuery("select * from talebeler where yazili_notu>90");
        while (rs.next()){
            System.out.printf("%-6d%-20s%-10s%-6d\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));

        }

    }
}
