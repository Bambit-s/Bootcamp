package com.roshka.bootcamp.model;

public class Sql5model {
    private int productoId;
    private String allProducts;

    public Sql5model(int productoId, String allProducts) {
        this.productoId = productoId;
        this.allProducts = allProducts;
    }

    public int getProductoId() { return productoId; }
    public String getAllProducts() { return allProducts; }

}
