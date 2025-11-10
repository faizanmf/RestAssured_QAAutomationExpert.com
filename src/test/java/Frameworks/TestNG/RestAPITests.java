package Frameworks.TestNG;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAPITests {

    @Test(description = "To get the details of user with id 3", priority = 0)
    public void verifyUser() {

        // Given
        given()
                .header("x-api-key", "reqres-free-v1")
                // When
                .when()
                .get("https://reqres.in/api/users/3")

                // Then
                .then()
                .statusCode(200)

                .statusLine("HTTP/1.1 200 OK")

                // To verify user of id 3
                .body("data.email", equalTo("emma.wong@reqres.in"))
                .body("data.first_name", equalTo("Emma"))
                .body("data.last_name", equalTo("Wong"));
    }

    @Test(description = "To create a new user", priority = 1)
    public void createUser() {

        JSONObject data = new JSONObject();

        data.put("name", "RestAPITest");
        data.put("job", "Testing");

        // GIVEN
        given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .header("x-api-key", "reqres-free-v1")
                // WHEN
                .when()
                .post("https://reqres.in/api/users")
        // THEN
                .then()
                .statusCode(201)
                .body("name", equalTo("RestAPITest"))
                .body("job", equalTo("Testing"));

    }

}