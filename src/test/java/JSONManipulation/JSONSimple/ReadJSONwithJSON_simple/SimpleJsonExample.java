package JSONManipulation.JSONSimple.ReadJSONwithJSON_simple;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleJsonExample {
    public static void main(String args[]) throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/SimpleJson/simple.json")));
        try {
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(jsonString);

            // Accessing the "store" object
            JsonObject store = (JsonObject) jsonObject.get("store");

            // Accessing the "book" object
            String book = (String) store.get("book");
            System.out.println("Book: " + book);

            // Accessing the "author" object
            String author = (String) store.get("author");
            System.out.println("Author - " + author);

            // Accessing the "price" field
            BigDecimal price = (BigDecimal) store.get("price");
            System.out.println("Price: " + price);

        } catch (JsonException e) {
            throw new RuntimeException(e);
        }
    }
}
