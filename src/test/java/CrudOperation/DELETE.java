package CrudOperation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.equalTo;

public class DELETE {
    public static void main(String[] args) {
        RequestSpecification req =new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com")
                .setBasePath("/api")
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectBody("message", equalTo("Successfully! Record has been deleted"))
                .build();

        RestAssured.given().spec(req)
                .when()
                .delete("/v1/delete/8461")
                .then()
                .spec(res)
                .log()
                .all();

    }
}
