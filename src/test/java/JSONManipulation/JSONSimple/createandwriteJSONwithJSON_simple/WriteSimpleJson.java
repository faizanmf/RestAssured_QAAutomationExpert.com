package JSONManipulation.JSONSimple.createandwriteJSONwithJSON_simple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileWriter;
import java.io.IOException;

public class WriteSimpleJson {
    public static void main(String[] args) {

        // JSON String
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("Name", "Vibha");
        jsonObject.put("Salary", 4500.00);

        // JSON Array
        JsonArray list = new JsonArray();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");

        jsonObject.put("Working Days", list);
        System.out.println(Jsoner.serialize(jsonObject));

        try (FileWriter fileWriter = new FileWriter("src/test/resources/Payloads/Employee.json")) {
            Jsoner.serialize(jsonObject, fileWriter);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
