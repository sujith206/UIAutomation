package com.apiAutomation.utilities;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URL;
import java.util.Map;

public class BaseAPI {
    protected RequestSpecification request;
    static {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.config = RestAssured.config().httpClient(HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout", 5000)
                .setParam("http.socket.timeout", 5000)
                .setParam("http.connection-manager.timeout", 5000)
                .setParam("https.socket.timeout", 5000)
                .setParam("https.connection.timeout", 5000)
                .setParam("https.connection-manager.timeout", 5000));
    }

    public BaseAPI() {
        request = RestAssured.given();
        request.proxy("desktop.proxy.sujith.com", 5150);
    }

    public Response doPostWithHeader(String endpoint, String payload, Map<String, String> mapParams) {
        Response response= null;
        response = request.headers(mapParams).relaxedHTTPSValidation().contentType(ContentType.JSON).body(payload)
                .log().all().post(endpoint).then().extract().response();
        return response;
    }
    // doPutWithHeader
    public Response doPutWithHeader(String endpoint, String payload, Map<String, String> mapParams) {
        Response response = null;
        response = request.headers(mapParams).relaxedHTTPSValidation().contentType(ContentType.JSON).body(payload)
                .log().all().put(endpoint).then().extract().response();
        return response;
    }
    //doGetWithHeader
    public Response doGetWithHeader(String endpoint, Map<String, String> mapParams) {
        Response response = null;
        response = request.headers(mapParams).relaxedHTTPSValidation().contentType(ContentType.JSON)
                .log().all().get(endpoint).then().extract().response();
        return response;
    }
}
