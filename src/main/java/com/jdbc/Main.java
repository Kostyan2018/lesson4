package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    private static String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
    //private static Connection connection;

    public static void main(String[] args) throws SQLException {

        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        String query = "select * from business.products where product_id = 13";
        Statement statement = conn.createStatement();
        ResultSet resSet = statement.executeQuery(query);

        while (resSet.next()) {
            int id;
            String name;
            double price;
            int shopID;

            id = resSet.getInt("product_Id");
            name = resSet.getString("product_name");
            price = resSet.getDouble("price");
            shopID = resSet.getInt("shop_id");

            Product product = new Product (id, name, price, shopID);
            System.out.println(product);
        }

        statement.close();
        conn.close();
    }
}

