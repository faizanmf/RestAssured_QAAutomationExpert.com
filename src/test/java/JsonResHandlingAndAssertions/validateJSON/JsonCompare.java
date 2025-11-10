package JsonResHandlingAndAssertions.validateJSON;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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
