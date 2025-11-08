package HeadersandParametersManagement.handleHTTPQueryParameters;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class verifyQueryParam {
    public static void main(String[] args) {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .addHeader("x-api-key", "reqres-free-v1")
                .addQueryParam("page", "2")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectBody("page", equalTo(2))
                .expectBody("per_page", equalTo(6))
                .expectBody("total_pages", equalTo(2))
                .build();

        RestAssured.given()
                .spec(req)
                .when()
                .get("/users")
                .then()
                .spec(res)
                .log().all();
    }
}
