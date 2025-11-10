package AuthenticationandTokenManagement.AccessTokenGeneratedByOAuth2ToARequest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GenerateOAuthToken {



   public static String generateToken()
   {
       Response response =
               given()
                       .contentType("application/x-www-form-urlencoded")
                       .formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                       .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")   // ✅ CORRECT
                       .formParam("grant_type", "client_credentials")
                       .formParam("scope", "trust")
                       .when()
                       .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                       .then()
                       .log().all()
                       .statusCode(200)
                       .extract().response();


       JsonPath js = response.jsonPath();

       System.out.println("Access Token : " + js.getString("access_token"));
       System.out.println("Refresh Token: " + js.getString("refresh_token"));
       System.out.println("Scope        : " + js.getString("scope"));

       return js.getString("access_token");
   }


    public static void main(String[] args) {
        generateToken();
    }
}
