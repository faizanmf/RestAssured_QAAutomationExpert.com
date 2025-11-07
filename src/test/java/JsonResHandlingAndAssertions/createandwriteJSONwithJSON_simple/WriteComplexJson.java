package JsonResHandlingAndAssertions.createandwriteJSONwithJSON_simple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileWriter;
import java.io.IOException;

public class WriteComplexJson {
    public static void main(String[] args) {

        JsonObject jsonObject = new JsonObject();

        // ✅ Name object
        JsonObject name = new JsonObject();
        name.put("Surname", "faizan");
        name.put("Forename", "mf");
        jsonObject.put("Name", name);

        // ✅ Bonus object
        JsonObject bonus = new JsonObject();
        bonus.put("Quaterly", 12000);
        bonus.put("Monthly", 4000);
        bonus.put("Yearly", 50000);

        // ✅ Salary object
        JsonObject salary = new JsonObject();
        salary.put("Fixed", 1175214);
        salary.put("Bonus", bonus);
        jsonObject.put("Salary", salary);

        // ✅ Working days array
        JsonArray list = new JsonArray();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");

        jsonObject.put("Working Days", list);

        // ✅ Print JSON
        System.out.println(Jsoner.serialize(jsonObject));

        // ✅ Write JSON to file
        try (FileWriter fileWriter = new FileWriter("src/test/resources/payloads/EmployeeDetails.json")) {
            Jsoner.serialize(jsonObject, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("JSON file created successfully!");
    }
}
