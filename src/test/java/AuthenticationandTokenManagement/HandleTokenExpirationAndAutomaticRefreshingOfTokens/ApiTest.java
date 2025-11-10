package AuthenticationandTokenManagement.HandleTokenExpirationAndAutomaticRefreshingOfTokens;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiTest {

    public static void getResponse() {

        String token = TokenGeneration.getAccessToken();

        Response response = given()
                .auth().oauth2(token)
                .when()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                .then()
                .log().all()
                .extract().response();

        System.out.println("\nFinal API Response:");
        System.out.println(response.asString());
    }

    public static void main(String[] args) {
        getResponse();
    }
}
