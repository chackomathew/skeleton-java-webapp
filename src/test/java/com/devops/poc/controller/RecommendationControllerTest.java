package com.devops.poc.controller;

import com.devops.poc.model.ProductRecommendation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chackomathew on 12/04/16.
 */
public class RecommendationControllerTest {

    //@Autowired
    RecommendationController recommendationController = new RecommendationController();

    @Test
    public void testGetRecommendations() throws Exception {
        ProductRecommendation recommendations = recommendationController.getRecommendations();
        assertTrue("Recommended products successfully", !recommendations.getProducts().getProducts().isEmpty());

    }
}