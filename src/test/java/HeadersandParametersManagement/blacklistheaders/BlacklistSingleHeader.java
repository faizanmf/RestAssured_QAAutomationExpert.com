package HeadersandParametersManagement.blacklistheaders;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class BlacklistSingleHeader {
    public static void main(String[] args) {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .addHeader("x-api-key", "reqres-free-v1")
                .setConfig(RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeader("Accept")))
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectBody("data.email", equalTo("janet.weaver@reqres.in"))
                .expectBody("data.first_name", equalTo("Janet"))
                .expectBody("data.last_name", equalTo("Weaver"))
                .build();

        RestAssured.given()
                .spec(req)
                .log().headers()
                .when()
                .get("/users/2")
                .then()
                .spec(res)
                .log().all();


    }
}
