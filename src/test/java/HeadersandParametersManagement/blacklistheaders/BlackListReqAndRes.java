package HeadersandParametersManagement.blacklistheaders;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class BlackListReqAndRes {
    public static void main(String[] args) {

        List<String> headers = new ArrayList<>();
        headers.add("Accept");
        headers.add("Content-Type");

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .setConfig(RestAssured.config()
                        .logConfig(LogConfig.logConfig()
                                .blacklistHeader(Arrays.toString(headers.toArray(new String[0])))))
                .build();


        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(200)
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
