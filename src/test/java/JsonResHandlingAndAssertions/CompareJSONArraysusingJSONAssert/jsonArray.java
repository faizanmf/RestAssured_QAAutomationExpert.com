package JsonResHandlingAndAssertions.CompareJSONArraysusingJSONAssert;

import org.json.JSONArray;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class jsonArray {
    public static void main(String[] args) {
        JSONObject data1 = new JSONObject();
        data1.put("first_name", "Vibha");
        data1.put("last_name", "Singh");

        JSONObject data2 = new JSONObject();
        data2.put("first_name", "Nysha");
        data2.put("last_name", "Verma");


        // Creating JSON array to add both JSON objects
        JSONArray array1 = new JSONArray();
        array1.put(data1);
        array1.put(data2);

        System.out.println("JSON Array :" + array1);

        //Second JSON Array

        JSONObject data3 = new JSONObject();
        data3.put("first_name", "Nysha");
        data3.put("last_name", "Verma");

        JSONObject data4 = new JSONObject();
        data4.put("first_name", "Vibha");
        data4.put("last_name", "Singh");

        // Creating JSON array to add both JSON objects
        JSONArray array2 = new JSONArray();
        array2.put(data3);
        array2.put(data4);

        System.out.println("JSON Array :" + array2);

        JSONAssert.assertEquals(array1, array2, JSONCompareMode.STRICT);
    }
}

