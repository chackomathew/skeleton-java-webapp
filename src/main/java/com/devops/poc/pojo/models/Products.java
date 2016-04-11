package com.devops.poc.pojo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by chackomathew on 11/04/16.
 */
public class Products {

    @JsonProperty("products")
    List<Product> products;

    public Products() {
    }

    public Products(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
