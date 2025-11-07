package JsonResHandlingAndAssertions.Hamcrest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;

public class HamcrestStringAssertions {
    public static void main(String[] args) {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setBasePath("/booking")
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectBody("firstname", equalTo("Susan"))
                .expectBody("firstname", equalToIgnoringCase("susan"))
                .expectBody("firstname", containsString("Susan"))
                .expectBody("firstname", startsWith("S"))
                .expectBody("firstname", endsWith("n"))
                .expectBody("firstname", equalToIgnoringWhiteSpace(" Susan "))
                .build();

        RestAssured.given()
                .spec(req)
                .when()
                .get("/1")
                .then()
                .spec(res)
                .log().all();
    }
}
