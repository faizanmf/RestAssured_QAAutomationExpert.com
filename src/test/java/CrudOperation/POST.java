package CrudOperation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.core.IsEqual.equalTo;

public class POST {
    public static void main(String[] args) {
        String json ="{\"name\":\"6novTest\",\"salary\":\"1000\",\"age\":\"25\"}";

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com")
                .setBasePath("/api/v1")
                .setContentType(ContentType.JSON)
                .setBody(json)
                .build();

        ResponseSpecification res =new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectBody("data.name", equalTo("6novTest"))
                .expectBody("message", equalTo("Successfully! Record has been added."))
                .build();

        RestAssured
                .given()
                .spec(req)
                .when()
                .post("/create")
                .then()
                .spec(res)
                .log().all();


    }
}
