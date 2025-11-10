package TestingEnhancements.RA_ParamTests_JUnit4;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(DataProviderRunner.class)
public class ParameterizedTests {

    @DataProvider
    public static Object[][] responseData() {
        return new Object[][]{
                {"1", "George", "Bluth"},
                {"2", "Janet", "Weaver"},
                {"3", "Emma", "Wong"},
                {"4", "Eve", "Holt"}
        };
    }

    @Test
    @UseDataProvider("responseData")
    public void verifyResponse(String id, String expectedFirstName, String expectedLastName) {

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/users")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectBody("data.first_name", equalTo(expectedFirstName))
                .expectBody("data.last_name", equalTo(expectedLastName))
                .build();

        RestAssured.given()
                .spec(req)
                .when()
                .get(id)
                .then()
                .spec(res)
                .log().ifStatusCodeIsEqualTo(200);
    }
}
