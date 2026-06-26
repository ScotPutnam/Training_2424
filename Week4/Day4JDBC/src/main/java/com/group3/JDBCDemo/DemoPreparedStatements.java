package com.group3.JDBCDemo;

import java.sql.*;

public class DemoPreparedStatements {
    private static final String URL = "jdbc:sqlite:week4_prep_demo";
    static void main(String[] args) throws SQLException {
        String userInput = "alice";

        // open db connection
        try(Connection conn = DriverManager.getConnection(URL)){
            try (Statement st = conn.createStatement()){

                st.executeUpdate("DROP TABLE IF EXISTS user_account");

                st.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS (
                        user_account_id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        secret TEXT NOT NULL
                    )
                """);

                // inserts sample data
                st.executeUpdate("INSERT INTO user_account VALUES ('alice', 'pw1'),('bob','pw2')");

            }
            // unsafe example
            System.out.println("Unsafe concatenation");
            // user input is put directly into SQL statement
            String unsafeSQL =
                    "SELECT name, secret FROM user_account WHERE name = '"+userInput+"'";
            System.out.println("SQL: " + unsafeSQL);

            try (Statement st = conn.createStatement()){
                ResultSet res = st.executeQuery(unsafeSQL);
                while (res.next()){
                    System.out.printf(
                            "matched: %s / %s%n",
                            res.getString(1),
                            res.getString(2)
                    );
                }
            }
            // create safe statement
            String safeSQL = "SELECT name, secret FROM user_account WHERE name = ?";
            // ? param placeholder
            try (PreparedStatement ps = conn.prepareStatement(safeSQL)){
                // bind user input to parameter
                ps.setString(1, userInput);

                // execute query
                try(ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        System.out.printf("matched: %s / %s%n",
                            rs.getString(1),
                            rs.getString(2));
                    }
                }
            }
        }
    }
}
