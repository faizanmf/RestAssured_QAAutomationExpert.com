package Frameworks.JUnit5;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITests {

    String BaseURL = "https://reqres.in/api";

    @Test
    public void createUser() {

        JSONObject data = new JSONObject();

        data.put("name", "NewUser1");
        data.put("job", "Testing");

        // GIVEN
        given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .header("x-api-key", "reqres-free-v1")

                // WHEN
                .when()
                .post(BaseURL + "/users")

                // THEN
                .then()
                .statusCode(201)
                .body("name", equalTo("NewUser1"))
                .body("job", equalTo("Testing"))
                .log().all();

    }

    @Test
    public void getUser() {  //Failed Test

        // GIVEN
        given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")

                // WHEN
                .when()
                .get(BaseURL + "/users/2")

                // THEN
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .log().all();

    }

}