package AuthenticationandTokenManagement.HandleTokenExpirationAndAutomaticRefreshingOfTokens;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.time.Instant;
public class TokenGeneration {
    private static String accessToken;
    private static Instant tokenExpiryTime;
    static Response response;
    static int expiresIn;

    // Method to obtain initial token
    public static String getAccessToken() {
        if (accessToken == null || isTokenExpired()) {
            refreshAccessToken();
        }
        return accessToken;
    }

    // Method to check if the token is expired
    private static boolean isTokenExpired() {
        return tokenExpiryTime == null || Instant.now().isAfter(tokenExpiryTime);
    }

    // Method to refresh token
    private static void refreshAccessToken() {
        response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token");

        accessToken = response.jsonPath().getString("access_token");
        expiresIn = response.jsonPath().getInt("expires_in");
        tokenExpiryTime = Instant.now().plusSeconds(expiresIn);

        System.out.println("Access Token: " + accessToken);
        System.out.println("Token Expiry Time: " + tokenExpiryTime);
    }

    public static void main(String[] args) {
        refreshAccessToken();
    }
}
