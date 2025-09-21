package com.apiAutomation.services;

import com.apiAutomation.utilities.BaseAPI;
import com.apiAutomation.utilities.Payload;
import groovyjarjarantlr4.v4.misc.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class CartService extends BaseAPI {
    public String baseurl="https://fakestoreapi.com";
    Hashtable<String, String> dataTable;
    public CartService(Hashtable<String, String> dataTable) {
        this.dataTable = dataTable;

    }

    public Response addItemToCart() {
        // Logic to add item to cart
        String endpoint = baseurl+"/carts";
        String mapParamsKey = dataTable.get("HeaderKey");
        String mapParamsValue = dataTable.get("HeaderValue");
        Map<String, String> headerValues = new HashMap<>();
        headerValues.put(mapParamsKey, mapParamsValue);
        Payload payload = new Payload();
        String payloadValue= payload.getResourceContent("/payloads/AddItemToCart.json");
        String finalFormedPayload = payload.constructPayload(payloadValue, dataTable);
        Response response = doPostWithHeader(endpoint, finalFormedPayload, headerValues);
        // header and status code assertion
        int statusCode = response.getStatusCode();
        if (statusCode != Integer.parseInt(dataTable.get("StatusCode"))) {
            throw new AssertionError("Expected status code: " + dataTable.get("StatusCode") + " but found: " + statusCode);
        }
        String contentType = response.getHeader("Content-Type");
        if (!contentType.contains(dataTable.get("ContentType"))) {
            throw new AssertionError("Expected Content-Type: " + dataTable.get("ContentType") + " but found: " + contentType);
        }
        //Jsonpath assertions
        JsonPath jsonPath = response.jsonPath();
        String userId = jsonPath.getString("userId");
        if (!userId.equals(dataTable.get("userId"))) {
            throw new AssertionError("Expected userId: " + dataTable.get("userId") + " but found: " + userId);
        }

        return response;
    }
}
