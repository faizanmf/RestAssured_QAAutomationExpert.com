package JsonResHandlingAndAssertions.CompareJSONObjectusingJSONAssertLibrary;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class differentJsonWithStrict {
    public static void main(String[] args) {
        String jsonObject1 = "{ " +
                "\"first_name\" : \"Vibha\"," +
                "\"last_name\": \"Singh\"" +
                "}";

        String jsonObject2 ="{ " +
                "\"first_name\" : \"Vibha\"," +
                "\"last_name\": \"Singh\"," +
                "\"salary\": \"115000\"" +
                "}";

        //JSONAssert.assertEquals("JSONs are not equal",jsonObject1, jsonObject2, JSONCompareMode.STRICT);

        JSONAssert.assertEquals(jsonObject2, jsonObject1, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals(jsonObject2, jsonObject1, false);

        JSONAssert.assertEquals(jsonObject2, jsonObject1, JSONCompareMode.STRICT);
        JSONAssert.assertEquals(jsonObject2, jsonObject1, true);
    }

}

