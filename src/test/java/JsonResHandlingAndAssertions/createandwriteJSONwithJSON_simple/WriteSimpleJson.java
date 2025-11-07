package JsonResHandlingAndAssertions.createandwriteJSONwithJSON_simple;

import com.github.cliftonlabs.json_simple.Jsoner;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteSimpleJson {
    public static void main(String[] args) {
        JSONObject jo = new JSONObject();
        jo.put("Name", "faizan");
        jo.put("Salary", 11);

        JSONArray ja = new JSONArray();
        ja.put("monday");
        ja.put("tuesday");
        ja.put("wednesday");

        jo.put("Working days", ja);

        System.out.println(jo.toString(4));
        try (FileWriter fileWriter = new FileWriter("src/test/resources/payloads/Employee.json")) {
            fileWriter.write(jo.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("✅ JSON file created successfully!");
    }
}
