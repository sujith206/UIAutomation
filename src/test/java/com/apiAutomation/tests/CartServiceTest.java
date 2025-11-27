package com.apiAutomation.tests;

import com.apiAutomation.services.CartService;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CartServiceTest {

    @Test
    public void testAddItemToCart() {
        Hashtable<String, String> data = new Hashtable<>();
        data.put("HeaderKey", "Content-Type");
        data.put("HeaderValue", "application/json");
        data.put("StatusCode", "200");
        data.put("ContentType", "application/json");
        data.put("userId", "1");

        CartService cartService = new CartService(data);
        cartService.addItemToCart();
    }
}

