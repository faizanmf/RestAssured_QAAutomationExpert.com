package AdvReqPOSTManagement;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class JsonArrayReqBody {
    public static void main(String[] args) {
        JSONObject js =new JSONObject();
        js.put("employee_name", "Array1");
        js.put("employee_salary", "1251");
        js.put("employee_age", "51");
        js.put("profile_image", "");

        JSONObject js1 =new JSONObject();
        js1.put("employee_name", "Array2");
        js1.put("employee_salary", "1252");
        js1.put("employee_age", "52");
        js1.put("profile_image", "");

        JSONArray array = new JSONArray();
        array.put(js);
        array.put(js1);

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com")  // use HTTPS
                .setBasePath("/api/v1")
                .setContentType(ContentType.JSON)
                .setBody(array.toString())
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .expectBody("status", equalTo("success"))
                .expectBody("message", equalTo("Successfully! Record has been added."))
                .build();

        RestAssured
                .given()
                .spec(req)
                .when()
                .post("/create")
                .then()
                .spec(res)
                .log().all();

    }
}
