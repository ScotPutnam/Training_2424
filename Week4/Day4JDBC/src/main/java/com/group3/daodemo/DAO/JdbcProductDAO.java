package com.group3.daodemo.DAO;

import com.group3.daodemo.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcProductDAO implements ProductDAO{

    final String url = "jdbc:sqlite:week4_jdbc_dao_demo.db";
    private final Connection connection;
    public JdbcProductDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public long insert(Product product) throws SQLException {
        String sql =
                "INSERT INTO product (sku, name, price) VALUES (?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, product.getSku());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()){
                if(keys.next()){
                    return keys.getLong(1);
                }
            }
        }
        catch (IllegalStateException k){
            k.printStackTrace();
        }
        return 0;
    }

    @Override
    public Optional<Product> findBySku(String sku) throws Exception {
        String sql = "SELECT id, sku, name, price FROM product WHERE sku = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, sku);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    return Optional.of(mapRow(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void priceUpdate(String sku, double newPrice) throws SQLException {
        String SQL = "UPDATE product SET price = ? WHERE sku = ?";

        try (PreparedStatement ps = connection.prepareStatement(SQL)){
            ps.setDouble(1, newPrice);
            ps.setString(2, sku);
            int n = ps.executeUpdate();
            if (n!=1){
                throw new IllegalStateException("Expected 1 row updated, got " + n);
            }

        }
    }

    @Override
    public void deleteBySku(String sku) throws SQLException {


    }

    @Override
    public List<Product> readAll() throws SQLException {
        String sql = "SELECT id,sku,name,price FROM product ORDER by id";
        List<Product> out = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                out.add(mapRow(rs));
            }
        }
        return out;
    }

    private Product mapRow(ResultSet rs) throws SQLException {
        return new Product(
                rs.getLong("id"),
                rs.getString("sku"),
                rs.getString("name"),
                rs.getDouble("price")
        );
    }
}
