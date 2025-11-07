package AdvReqPOSTManagement;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class ExcelFileJson {
    public static void main(String[] args) {
        File jsonData = new File("src/test/resources/payloads/jsondemo.json");
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setBasePath("/api")
                .setContentType(ContentType.JSON)
                .setBody(jsonData)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectBody("status", equalTo("success"))
                .expectBody("message", equalTo("Successfully! Record has been added."))
                .build();

        RestAssured
                .given()
                .spec(req)
                .when()
                .post("/users")
                .then()
                .spec(res)
                .log().all();
    }
}
