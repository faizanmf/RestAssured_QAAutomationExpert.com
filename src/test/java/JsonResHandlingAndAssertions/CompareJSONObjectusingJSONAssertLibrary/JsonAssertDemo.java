package JsonResHandlingAndAssertions.CompareJSONObjectusingJSONAssertLibrary;

import com.jayway.jsonpath.JsonPath;
import io.restassured.internal.path.json.JSONAssertion;
import org.json.JSONArray;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class JsonAssertDemo {
    public static void main(String[] args) {
        String jsonObject1 = "{ " +
                "\"first_name\" : \"faizan\"," +
                "\"last_name\": \"mf\"" +
                "}";

        String jsonObject2 = "{ " +
                "\"first_name\" : \"faizan\"," +
                "\"last_name\": \"mf\"" +
                "}";

        JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.LENIENT);
    }
}
