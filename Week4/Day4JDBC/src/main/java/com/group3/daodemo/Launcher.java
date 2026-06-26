package com.group3.daodemo;

import com.group3.daodemo.DAO.JdbcProductDAO;
import com.group3.daodemo.DAO.ProductDAO;
import com.group3.daodemo.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class Launcher {

    static void main(String[] args) {
        String url = "jdbc:sqlite:week4_jdbc_dao_demo.db";


        try (Connection conn = DriverManager.getConnection(url)){
            try(Statement st = conn.createStatement()){
                st.executeUpdate("DROP TABLE IF EXISTS product");
                st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS product (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    sku TEXT NOT NULL UNIQUE,
                    name TEXT NOT NULL,
                    price REAL NOT NULL
                )                
                """);
            }
            JdbcProductDAO dao = new JdbcProductDAO(conn);
            Product p = new Product(0, "SKU-1", "Mug", 12.5);

            long id = dao.insert(p);
            System.out.println("inserted id = " + id);

            List<Product> products = dao.readAll();

            for (Product p1 : products){
                System.out.println(p.getName());
            }

            Optional<Product> loaded = dao.findBySku("SKU-1");
            loaded.ifPresent(System.out::println);

            dao.priceUpdate("SKU-1", 11.99);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
