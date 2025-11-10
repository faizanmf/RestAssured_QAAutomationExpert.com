package JSONManipulation.JSONSimple.ReadJSONwithJSON_simple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ComplexJsonExample {

    public static void main(String args[]) throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/SimpleJson/complex.json")));
        try {
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(jsonString);

            // Accessing the "store" object
            JsonObject store = (JsonObject) jsonObject.get("store");

            // Accessing the "book" array
            JsonArray books = (JsonArray) store.get("book");
            for (Object bookObj : books) {
                JsonObject book = (JsonObject) bookObj;
                String category = (String) book.get("category");
                String author = (String) book.get("author");
                String title = (String) book.get("title");
                BigDecimal price = (BigDecimal) book.get("price");

                System.out.println("Book: " + title + " (Category: " + category + ", Author: " + author + ", Price: " + price + ")");
            }

            // Accessing the "bicycle" object
            JsonObject bicycle = (JsonObject) store.get("bicycle");
            String color = (String) bicycle.get("color");
            BigDecimal bicyclePrice = (BigDecimal) bicycle.get("price");
            System.out.println("Bicycle: Color - " + color + ", Price - " + bicyclePrice);

            // Accessing the "expensive" field
            BigDecimal expensiveValue = (BigDecimal) jsonObject.get("expensive");
            System.out.println("Expensive threshold: " + expensiveValue);

        } catch (JsonException e) {
            throw new RuntimeException(e);
        }
    }
}
