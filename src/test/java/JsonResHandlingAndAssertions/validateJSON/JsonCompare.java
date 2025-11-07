package JsonResHandlingAndAssertions.validateJSON;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class JsonCompare {
    public static void main(String[] args) {

        given()
                .when()
                .get("https://reqres.in/api/users/3")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("payloads/User.json"));
                //.log().all();
    }
}
