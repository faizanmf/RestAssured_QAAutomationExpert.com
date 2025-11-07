package CrudOperation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class PUT {
    public static void main(String[] args) {
        String json = "{"
                + "\"employee_name\": \"6nov2025Test\","
                + "\"employee_salary\": 2000,"
                + "\"employee_age\": 34,"
                + "\"profile_image\": \"\""
                + "}";

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com")  // use HTTPS
                .setBasePath("/api/v1")
                .setContentType(ContentType.JSON)
                .setBody(json)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectBody("status", equalTo("success"))
                .expectBody("data.employee_name", equalTo("6nov2025Test"))
                .build();

        RestAssured
                .given()
                .spec(req)
                .when()
                .put("/update/8461")
                .then()
                .spec(res)
                .log().all();
    }
}
