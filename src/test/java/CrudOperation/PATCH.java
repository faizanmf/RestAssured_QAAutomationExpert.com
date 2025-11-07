package CrudOperation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.equalTo;

public class PATCH {
    public static void main(String[] args) {

        String json = "{\"name\": \"William\"}";

        RequestSpecification req =new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com")
                .setBasePath("/api")
                .setContentType(ContentType.JSON)
                .setBody(json)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectBody("name", equalTo("William"))
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .build();

        RestAssured.given().spec(req)
                .when()
                .patch("users/2")
                .then()
                .spec(res)
                .log()
                .all();



    }
}
