package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    private static String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";

    public static void main(String[] args) throws SQLException {

        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        String query = "select * from business.products";

        PreparedStatement preStat = conn.prepareStatement(query);
        ResultSet resSet = preStat.executeQuery();

        String INSERT = "insert into business.products (product_name, price, shop_id) values(?, ?, ?)";
        PreparedStatement prepInsert = conn.prepareStatement(INSERT);
        prepInsert.setString(1 , "Ololo");
        prepInsert.setDouble(2 , 98.0);
        prepInsert.setInt(3,3);
        prepInsert.execute();
        
        while (resSet.next()){
            System.out.println(resSet.getInt("product_id") + " " + resSet.getString("product_name"));
        }
        preStat.close();
        conn.close();
    }
}

