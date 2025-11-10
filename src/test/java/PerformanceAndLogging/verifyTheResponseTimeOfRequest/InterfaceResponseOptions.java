package PerformanceAndLogging.verifyTheResponseTimeOfRequest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

public class InterfaceResponseOptions {
    public static void main(String[] args) {

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .build();

        Response response = RestAssured.given()
                .spec(req)
                .when()
                .get("/users/2")
                .then()
                .spec(res)
                .extract().response();

        String responseString = response.prettyPrint();

        System.out.println("Response Details : " + responseString);

        System.out.println("Response Time in milliseconds: " + response.getTime());

        System.out.println("Response Time in seconds: " + response.getTimeIn(TimeUnit.SECONDS));

        System.out.println("Response Time in milliseconds: " + response.time());

        System.out.println("Response Time in seconds: " + response.timeIn(TimeUnit.SECONDS));
    }
}
