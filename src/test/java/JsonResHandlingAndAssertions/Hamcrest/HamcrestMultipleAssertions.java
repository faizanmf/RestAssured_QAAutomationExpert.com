package JsonResHandlingAndAssertions.Hamcrest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.core.IsEqual.equalTo;
public class HamcrestMultipleAssertions
{
    public static void main(String[] args) {

        RestAssured.given().contentType(ContentType.JSON)
                .when().get("https://restful-booker.herokuapp.com/booking/1").then()
                .body("firstname", equalTo("Eric"),
                        "lastname", equalTo("Brown"),
                        "totalprice", equalTo(128))
                .log().all();
    }
}
