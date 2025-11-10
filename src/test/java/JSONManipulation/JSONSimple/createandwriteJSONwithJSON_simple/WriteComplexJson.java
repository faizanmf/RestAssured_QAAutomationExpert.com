package JSONManipulation.JSONSimple.createandwriteJSONwithJSON_simple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileWriter;
import java.io.IOException;

public class WriteComplexJson {


    public static void main(String[] args) {

        JsonObject jsonObject = new JsonObject();

        //Name
        JsonObject name = new JsonObject();
        name.put("Forename", "Vibha");
        name.put("Surname", "Singh");
        jsonObject.put("Name", name);

        //Salary
        JsonObject salary = new JsonObject();
        salary.put("Fixed", 4000.00);

        //Bonus
        JsonObject bonus = new JsonObject();
        bonus.put("Monthly", 45.00);
        bonus.put("Quaterly", 125.00);
        bonus.put("Yearly", 500.00);

        salary.put("Bonus",  bonus);
        jsonObject.put("Salary", salary);

        // JSON Array
        JsonArray list = new JsonArray();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        jsonObject.put("Working Days", list);

        System.out.println(Jsoner.serialize(jsonObject));

        try (FileWriter fileWriter = new FileWriter("src/test/resources/Payloads/EmployeeDetails.json")) {
            Jsoner.serialize(jsonObject, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
