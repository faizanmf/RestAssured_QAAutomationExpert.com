package HeadersandParametersManagement.verifyJSONresponseheaders;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class verifyResponseHeader {
    public static void main(String[] args) {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectHeader("Content-Type" , "application/json; charset=utf-8")
                .expectHeader("Content-Encoding" , "gzip")
                .expectHeader("Server" , containsString("cloudflare"))
                .build();

        RestAssured.given()
                .spec(req)
                .when()
                .get("/users/2")
                .then()
                .spec(res)
                .log().all();
    }
}
