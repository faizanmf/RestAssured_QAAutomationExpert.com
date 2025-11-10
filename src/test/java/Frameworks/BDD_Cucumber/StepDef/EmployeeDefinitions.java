package Frameworks.BDD_Cucumber.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class EmployeeDefinitions {

    private static final String URL = "http://dummy.restapiexample.com/api/v1/employee/1";
    private Response response;

    @Given("I send a request to endpoint")
    public void sendRequest() {
        response = RestAssured
                .given()
                .contentType("application/json")
                .when()
                .get(URL);
    }

    @Then("the API should return status {int}")
    public void verifyResponse(int status) {
        response.then().statusCode(status);
    }

    @And("Response should contain employee name {string}")
    public void verifyResponseContent(String expectedEmployeeName) {
        response.then().body("data.employee_name", equalTo(expectedEmployeeName));
    }
}
