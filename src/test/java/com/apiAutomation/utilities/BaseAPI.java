package com.apiAutomation.utilities;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
        // Make proxy optional: set system properties -DuseProxy=true -DproxyHost=host -DproxyPort=port when needed
        String useProxy = System.getProperty("useProxy", "false");
        if (useProxy.equalsIgnoreCase("true")) {
            String proxyHost = System.getProperty("proxyHost", "desktop.proxy.sujith.com");
            String proxyPort = System.getProperty("proxyPort", "5150");
            try {
                int port = Integer.parseInt(proxyPort);
                request.proxy(proxyHost, port);
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public Response doPostWithHeader(String endpoint, String payload, Map<String, String> mapParams) {
        return request.headers(mapParams).relaxedHTTPSValidation().contentType(ContentType.JSON).body(payload)
                .log().all().post(endpoint).then().extract().response();
    }
    // doPutWithHeader
    public Response doPutWithHeader(String endpoint, String payload, Map<String, String> mapParams) {
        return request.headers(mapParams).relaxedHTTPSValidation().contentType(ContentType.JSON).body(payload)
                .log().all().put(endpoint).then().extract().response();
    }
    //doGetWithHeader
    public Response doGetWithHeader(String endpoint, Map<String, String> mapParams) {
        return request.headers(mapParams).relaxedHTTPSValidation().contentType(ContentType.JSON)
                .log().all().get(endpoint).then().extract().response();
    }
}
