package AdvReqPOSTManagement;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class UsingJavaMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("employee_name", "usingjavaMap");
        map.put("employee_salary", "1244");
        map.put("employee_age", "44");
        map.put("profile_image", "");

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com")  // use HTTPS
                .setBasePath("/api/v1")
                .setContentType(ContentType.JSON)
                .setBody(map)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectBody("status", equalTo("success"))
                .expectBody("data.employee_name", equalTo("usingjavaMap"))
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
