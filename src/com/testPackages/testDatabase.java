package com.testPackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class testDatabase
{
	public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/home/deepanshu/practical/Database/matrixDatabase";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT * from tables_csv;");
            while(rs.next())
            {
            	String name = rs.getString(1);
            	System.out.println(name);
            }
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
public static void main(String... args)
{
	connect();
}
}