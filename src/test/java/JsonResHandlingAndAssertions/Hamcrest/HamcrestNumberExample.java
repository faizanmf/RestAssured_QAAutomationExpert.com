package JsonResHandlingAndAssertions.Hamcrest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class HamcrestNumberExample {
    public static void main(String[] args) {


        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setBasePath("/booking")
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectBody("totalprice", equalTo(740))
                .expectBody("totalprice", greaterThan(100))
                .expectBody("totalprice", greaterThanOrEqualTo(50))
                .expectBody("totalprice", lessThan(1000))
                .expectBody("totalprice", lessThanOrEqualTo(1000))
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
