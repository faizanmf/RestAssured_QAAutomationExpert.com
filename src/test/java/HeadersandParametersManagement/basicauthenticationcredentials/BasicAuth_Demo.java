package HeadersandParametersManagement.basicauthenticationcredentials;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class BasicAuth_Demo {
    public static void main(String[] args) {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://httpbin.org")
                .setBasePath("/basic-auth")
                .addHeader("Accept", "application/json")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .build();

        RestAssured.given()
                .spec(req)
                .auth().preemptive().basic("user", "pass")
                .when()
                .get("/user/pass")
                .then()
                .spec(res)
                .log().all();


    }
}
