package br.com.springcloudproducerrest.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    String name;

    String category;

    Double value;

    Integer quantity;

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
