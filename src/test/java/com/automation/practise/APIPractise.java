package com.automation.practise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class APIPractise {

    public static void main(String[] args) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type","application/json");
        headers.put("Authorization","Bearer your_token_here");
        headers.put("Accept", "application/json");

//        Response response = RestAssured.given().headers(headers).contentType(ContentType.JSON).body("Sujith")
//                .log().all().when().post("https://reqres.in/api/users").then().extract().response();

        for (String key : headers.keySet()){
            System.out.println("The keys is :"+key + " "+ "The Key value is :"+headers.get(key));
        }
    }
}
