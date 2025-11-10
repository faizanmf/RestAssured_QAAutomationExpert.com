package HeadersandParametersManagement.passauthorizationtokeninheader;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class validateToken {
    public static void main(String[] args) {

        final String TOKEN = "Basic dXNlcjpwYXNz";

                RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://httpbin.org")
                .setBasePath("/basic-auth")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", TOKEN)
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("authenticated", equalTo(true))
                .expectBody("user", equalTo("user"))
                .build();

        Response response = RestAssured.given()
                .spec(req)
                .log().all()
                .when()
                .get("/user/pass")
                .then()
                .spec(res)
                .log().all()
                .extract()
                .response();

        assertThat(response.getStatusCode(), equalTo(200));

    }
}
