package com.scotputnam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class ConnectionUtil {

    // eventually returns object of type Connection
    // used to interact with our DB
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.sqlite.JDBC");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Problem occurred locating driver");
        }
        String url = "jdbc:sqlite:src/dbfile/dbfile";
        return DriverManager.getConnection(url);
    }
}
