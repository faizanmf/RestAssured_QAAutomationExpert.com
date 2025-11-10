package HeadersandParametersManagement.AddContentTypetorequest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;

import static org.hamcrest.Matchers.*;

public class WithContentType_Demo {
    public static void main(String[] args) {
        JSONObject data = new JSONObject();

        data.put("name", "faizan");
        data.put("job", "QA");

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .addHeader("x-api-key", "reqres-free-v1")
                .setBody(data.toString())
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectBody("name", equalToIgnoringCase("faizan"))
                .expectBody("job", equalToIgnoringCase("QA"))
                .build();

        RestAssured.given()
                .spec(req)
                .log().all()
                .when()
                .post("/users")
                .then()
                .spec(res)
                .log().all();
    }
}
