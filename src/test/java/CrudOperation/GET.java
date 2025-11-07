package CrudOperation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GET {
    public static void main(String[] args) {

        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com")
                .setBasePath("/api/v1")
                .build();

        ResponseSpecification resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RestAssured
                .given()
                .spec(reqSpec)
                .when()
                .get("/employee/8461")
                .then()
                .spec(resSpec)
                .log().all();
    }
}
