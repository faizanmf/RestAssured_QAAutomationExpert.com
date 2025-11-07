package JsonResHandlingAndAssertions.CompareJSONObjectusingJSONAssertLibrary;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class sameJsonWithDifferentDataType {
    public static void main(String[] args) {
        String jsonObject1 = "{ " +
                "\"first_name\" : \"Vibha\"," +
                "\"last_name\": \"Singh\"," +
                "\"salary\": 115000" +
                "}";

        String jsonObject2 ="{ " +
                "\"first_name\" : \"Vibha\"," +
                "\"last_name\": \"Singh\"," +
                "\"salary\": \"115000\"" +
                "}";

        JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.LENIENT);
    }

}

