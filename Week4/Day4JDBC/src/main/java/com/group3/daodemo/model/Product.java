package com.group3.daodemo.model;

public final class Product {
    private long id;
    private String sku;
    private String name;
    private double price;

    public Product(long id, String sku, String name, double price) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
