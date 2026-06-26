package com.group3.daodemo.DAO;

import com.group3.daodemo.model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// DAO
// Defines database operations without specifying how
public interface ProductDAO {

    // CREATE
    long insert(Product product) throws SQLException;

    // READ
    Optional<Product> findBySku(String sku) throws Exception;

    // UPDATE
    void priceUpdate(String sku, double newPrice) throws SQLException;

    // DELETE
    void deleteBySku (String sku) throws SQLException;

    // READ ALL
    List<Product> readAll() throws SQLException;
}
