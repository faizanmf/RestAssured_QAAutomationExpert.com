package JsonResHandlingAndAssertions.MultipleAssertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class multipleAssertions {

    public static void verifyHardAssertion()
    {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"));

    }

    public static void verifySoftAssertion()
    {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .body("data.email", equalTo("janet.weaver@reqres.in"),
                        "data.first_name", equalTo("Janet"),
                        "data.last_name", equalTo("Weaver"));

    }
    public static void main(String[] args) {
        verifyHardAssertion();
        verifySoftAssertion();


    }
}
