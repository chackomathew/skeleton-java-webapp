package com.devops.poc.controller;

import com.devops.poc.model.Product;
import com.devops.poc.model.ProductRecommendation;
import com.devops.poc.model.Products;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chackomathew on 11/04/16.
 */
@RestController
@RequestMapping("api")
// enable cross origin requests, all origins are enabled by default.
@CrossOrigin
public class RecommendationController {

    @RequestMapping(value = "recommendations", method = RequestMethod.GET)
    @ResponseBody
    public ProductRecommendation getRecommendations() {

        List<Product> productList = new ArrayList<>(6);
        productList.add(new Product("../images/shoes/other/shoe1.jpg", "Fuma Men's FumaStreetsalaDP Sneakers", "Item Description", 4.5, 2099.00));
        productList.add(new Product("../images/shoes/other/shoe2.jpg", "UFB Men's Sneakers", "Item Description", 4.0, 2058.00));
        productList.add(new Product("../images/shoes/other/shoe3.jpg", "Uila Men's Attavio Sneakers", "Item Description", 3.5, 2500.00));
        productList.add(new Product("../images/shoes/other/shoe4.jpg", "Dee Cooper Men's Canvas Sneakers", "Item Description", 4.75, 3099.00));
        productList.add(new Product("../images/shoes/other/shoe5.jpg", "Uila Men's Rock In Sneakers", "Item Description", 5.0, 5199.00));
        productList.add(new Product("../images/shoes/other/shoe6.jpg", "UK Knights Men's Wood Grey and Black Sneakers", "Item Description", 3.0, 1599.00));

        Products products = new Products(productList);
        return new ProductRecommendation(products);

    }

}
