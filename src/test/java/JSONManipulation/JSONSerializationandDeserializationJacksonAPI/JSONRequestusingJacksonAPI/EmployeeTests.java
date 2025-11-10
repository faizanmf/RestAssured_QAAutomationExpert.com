package JSONManipulation.JSONSerializationandDeserializationJacksonAPI.JSONRequestusingJacksonAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class EmployeeTests
{

    @Test
    public void createEmployee() {

        // Create an object of POJO class
        EmployeeDetails emp = new EmployeeDetails();
        emp.setName("Vibha");
        emp.setSalary(75000);
        emp.setAge(30);

        // Converting a Java class object to a JSON payload as string
        ObjectMapper mapper = new ObjectMapper();
        String employeePrettyJson = null;
        try {
            employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Request");
        System.out.println(employeePrettyJson);
        System.out.println("=========================================");
        System.out.println("Response");

        // GIVEN
        given().baseUri("https://dummy.restapiexample.com/api")
                .contentType(ContentType.JSON)
                .body(emp)

                // WHEN
                .when()
                .post("/v1/create")

                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.name", equalTo("Vibha"))
                .body("message", equalTo("Successfully! Record has been added."))
                .log().body();

    }
}
