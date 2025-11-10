package AuthenticationandTokenManagement.AccessTokenGeneratedByOAuth2ToARequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testRequest {
    public static void main(String[] args) {

        // ✅ Generate token only once
        String accessToken = GenerateOAuthToken.generateToken();

        Response response = RestAssured.given()
                .auth().oauth2(accessToken)
                .when()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails?access_token=" + accessToken)
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("Response :" + response.asString());
    }
}
