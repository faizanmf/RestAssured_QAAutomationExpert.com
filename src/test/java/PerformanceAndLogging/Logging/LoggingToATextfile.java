package PerformanceAndLogging.Logging;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.equalTo;

public class LoggingToATextfile {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream log = new PrintStream(new FileOutputStream("src/test/resources/LogFile/logging.txt"));
        String body = "{\\\"name\\\":\\\"apitest\\\",\\\"salary\\\":\\\"5000\\\",\\\"age\\\":\\\"30\\\"}";
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .addHeader("x-api-key", "reqres-free-v1")
                .setContentType(ContentType.JSON)
                .setBody(body)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectBody("data.email", equalTo("janet.weaver@reqres.in"))
                .expectBody("data.first_name", equalTo("Janet"))
                .expectBody("data.last_name", equalTo("Weaver"))
                .build();

        RestAssured.given()
                .spec(req)
                .when()
                .get("/users/2")
                .then()
                .spec(res)
                .log().ifStatusCodeIsEqualTo(200);
    }
}
