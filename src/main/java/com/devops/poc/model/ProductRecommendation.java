package com.devops.poc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chackomathew on 11/04/16.
 */
public class ProductRecommendation {

    @JsonProperty("productRecommendation")
    private Products products;

    public ProductRecommendation() {
    }

    public ProductRecommendation(Products products) {
        this.products = products;
    }

    public Products getProducts() {
        return products;
    }
}
