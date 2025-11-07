package JsonResHandlingAndAssertions.ReadJSONwithJSON_simple;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleJsonExample {
    public static void main(String[] args) throws IOException {

        String jsonString = new String(
                Files.readAllBytes(Paths.get("src/test/resources/payloads/simple.json"))
        );

        try {
            JsonObject jo = (JsonObject) Jsoner.deserialize(jsonString);

            JsonObject store = (JsonObject) jo.get("store");

            String book = (String) store.get("book");
            System.out.println("Book: " + book);

            String author = (String) store.get("author");
            System.out.println("Author: " + author);

            BigDecimal price = (BigDecimal) store.get("price");
            System.out.println("Price: " + price);

        } catch (com.github.cliftonlabs.json_simple.JsonException e) {
            throw new RuntimeException(e);
        }
    }
}
