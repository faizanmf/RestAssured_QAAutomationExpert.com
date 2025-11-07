package AdvReqPOSTManagement;

import org.json.JSONArray;
import org.json.JSONObject;

public class PrintPrettyJson {
    public void passBodyAsJsonArray1() {

        // Creating JSON array to add first JSON object
        JSONArray array1 = new JSONArray();
        array1.put(new JSONObject().put("firstname", "Tom").put("lastname", "Mathew").put("age", 59).put("salary",
                720000));

        // Creating JSON array
        JSONArray array2 = new JSONArray();
        array2.put(new JSONObject().put("firstname", "Perry").put("lastname", "David").put("age", 32).put("salary",
                365000));

        // Create JSON Object to add JSONArrays
        JSONObject data1 = new JSONObject();
        data1.put("employee1", array1);
        data1.put("employee2", array2);

        System.out.println(data1.toString(1));

    }



    public static void main(String[] args) {

        PrintPrettyJson obj = new PrintPrettyJson();
        obj.passBodyAsJsonArray1();

    }
}
