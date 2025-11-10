package TestingEnhancements.testSOAPServices;

import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestAssured_SOAPDemo {

    public static void main(String[] args) {

        // ✅ Load XML from resources folder
        File requestBody = new File("src/test/resources/XML_file/Number.xml");

        // ✅ Make SOAP request
        Response response = given()
                .baseUri("http://www.dneonline.com")
                .basePath("/calculator.asmx")
                .header("Content-Type", "text/xml; charset=utf-8")
                .header("SOAPAction", "http://tempuri.org/Subtract")   // ✅ REQUIRED
                .body(requestBody)
                .post();

        System.out.println(response.prettyPrint());

        // ✅ Extract result using correct XPath
        String xPathResult = response.xmlPath().getString("Envelope.Body.SubtractResponse.SubtractResult");
        int result = Integer.parseInt(xPathResult);

        System.out.println("xPathResult: " + xPathResult);
        System.out.println("result: " + result);

        // ✅ Validations
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(result, 13);  // 18 - 5 = 13
    }
}
