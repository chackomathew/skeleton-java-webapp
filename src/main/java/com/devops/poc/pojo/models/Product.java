package com.devops.poc.pojo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chackomathew on 11/04/16.
 */
public class Product {
    @JsonProperty("imageUrl")
    private String image;
    @JsonProperty("productName")
    private String name;
    @JsonIgnore
    private String description;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("price")
    private Double price;

    // for serialization
    public Product() {
    }

    public Product(String image, String name, String description, Double rating, Double price) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getRating() {
        return rating;
    }

    public Double getPrice() {
        return price;
    }
}
