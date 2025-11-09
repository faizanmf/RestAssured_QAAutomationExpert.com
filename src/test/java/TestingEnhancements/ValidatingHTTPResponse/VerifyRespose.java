package TestingEnhancements.ValidatingHTTPResponse;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.Test;

public class VerifyRespose {
    @Test
    public void verifyStatusCode()
    {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/users")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .build();

       Response response = RestAssured.given()
                .spec(req)
                .when()
                .get("/2")
                .then()
                .spec(res).extract().response();


        int actualStatusCode = response.getStatusCode();
        System.out.println("Status Code : " + actualStatusCode);

        Assert.assertEquals(200, actualStatusCode);
    }

    @Test
    public void verifyStatusLine()
    {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/users")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .build();

        Response response = RestAssured.given()
                .spec(req)
                .when()
                .get("/2")
                .then()
                .spec(res).extract().response();


        String actualStatusLine = response.getStatusLine();
        System.out.println("Status Line : " + actualStatusLine);

        Assert.assertEquals("HTTP/1.1 200 OK", actualStatusLine);
    }

    @Test
    public void verifyResponseBody()
    {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/users")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .build();

        Response response = RestAssured.given()
                .spec(req)
                .when()
                .get("/2")
                .then()
                .spec(res).extract().response();


        String actualResponseBody = response.getBody().asString();
        System.out.println("Response Body : " + actualResponseBody);

        JsonPath jsonPath = response.jsonPath();
        String actualResponse_Id = jsonPath.getString("data.id");
        System.out.println("Response Id : " + actualResponse_Id);

        Assert.assertEquals("2", actualResponse_Id);
    }

    @Test
    public void verifyResponseHeader()
    {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/users")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .build();

        Response response = RestAssured.given()
                .spec(req)
                .when()
                .get("/2")
                .then()
                .spec(res).extract().response();


        Headers allHeaders = response.getHeaders();
        System.out.println("All Headers : " + allHeaders);

        for(Header header: allHeaders){
            System.out.println(header.getName() +  ":" + header.getValue());
        }

        Assert.assertTrue(allHeaders.getValue("Content-Encoding").contains("gzip"));

    }

    @Test
    public void verifyContentType()
    {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/users")
                .addHeader("x-api-key", "reqres-free-v1")
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .build();

        Response response = RestAssured.given()
                .spec(req)
                .when()
                .get("/2")
                .then()
                .spec(res).extract().response();


        String actualContentType = response.getContentType();
        System.out.println("Actual ContentType : " + actualContentType);

        Assert.assertEquals("application/json; charset=utf-8", actualContentType);

    }

}



