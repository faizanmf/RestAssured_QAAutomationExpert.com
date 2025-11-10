package PerformanceAndLogging.verifyTheResponseTimeOfRequest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class InterfaceValidatableResponseOptions {
    public static void main(String[] args) {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .build();

        Response response = RestAssured.given()
                .spec(req)
                .when()
                .get("/users/2")
                .then()
                .spec(res)
                .time(Matchers.lessThan(3000L))
                .time(Matchers.greaterThan(200L))
                .extract().response();
    }
}
