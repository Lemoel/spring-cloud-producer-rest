package br.com.springcloudproducerrest.model;

import lombok.Data;

@Data
public class Product {

    private String name;

    private String category;

    private Double value;

    private Integer quantity;

    public Product() {
    }

    public Product(String name, String category, Double value, Integer quantity) {
        super();
        this.name = name;
        this.category = category;
        this.value = value;
        this.quantity = quantity;
    }
}
