package JsonResHandlingAndAssertions.CompareJSONObjectusingJSONAssertLibrary;

import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;

public class matchJsonObject {
    public static void main(String[] args) {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("first_name", "faizan");
        jsonObject1.put("last_name", "mf");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("first_name", "faizan");
        jsonObject2.put("last_name", "safa");

        JSONAssert.assertEquals("JSONs are not equal", jsonObject1, jsonObject2, false);
    }

}

