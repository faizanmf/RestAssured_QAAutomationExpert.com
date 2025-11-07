package JsonResHandlingAndAssertions.CompareJSONObjectusingJSONAssertLibrary;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class sameJsonWithDifferentValues {
    public static void main(String[] args) {
        String jsonObject1 = "{ " +
                "\"first_name\" : \"faizan\"," +
                "\"last_name\": \"mf\"" +
                "}";

        String jsonObject2 = "{ " +
                "\"first_name\" : \"faizan\"," +
                "\"last_name\": \"safa\"" +
                "}";

        JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.LENIENT);
    }
}
