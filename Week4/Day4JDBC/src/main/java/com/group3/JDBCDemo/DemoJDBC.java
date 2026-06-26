package com.group3.JDBCDemo;

import java.sql.*;

public class DemoJDBC {

    // JDBC creates if doesnt exists
    private static final String URL = "jdbc:sqlite:week4_jdbc_demo.db";

    // prepared statements prevent SQL injection
    public static void main(String[] args) {

        // open DB, try-with-resources automatically closes conn
        try (Connection conn = DriverManager.getConnection(URL)){

            bootstrap_schema(conn);

            try (PreparedStatement ins = conn.prepareStatement("INSERT INTO customer VALUES (?, ?)")){
                ins.setString(1, "John Smith");
                ins.setString(2, "johns@email.com");

                ins.executeUpdate();
            }

            try (PreparedStatement q = conn.prepareStatement("SELECT customer_id, f_name, email FROM customer WHERE email = ?")){
                q.setString(1, "johns@email.com");

                try (ResultSet rs = q.executeQuery()){
                    while(rs.next()){
                        long id = rs.getLong("id");
                        String email = rs.getString("email");
                        String f_name = rs.getString("f_name");

                        System.out.printf("row: id=%d email=%s name=%s%n",
                                id,
                                email,
                                f_name);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void bootstrap_schema(Connection conn) throws SQLException{

        try (Statement st = conn.createStatement()){
            // clears old table
            st.executeUpdate("DROP TABLE IF EXISTS customer");

            // create new table
            st.executeUpdate(""" 
                CREATE TABLE IF NOT EXISTS CREATE TABLE IF NOT EXISTS users (
                    customer_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    f_name TEXT NOT NULL UNIQUE,
                    email TEXT NOT NULL,
                    age INTEGER CHECK(age >= 18),
                    signup_date TEXT DEFAULT CURRENT_TIMESTAMP 
                """
            );
        }
    }

}
