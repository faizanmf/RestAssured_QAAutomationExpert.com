package JsonResHandlingAndAssertions.ExtractionFromJSON_JsonPath;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonPath_Demo {
    public static void main(String[] args) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/Payloads/test.json")));

        String allBooks = JsonPath.read(jsonString, "$..*").toString();
        System.out.println("--------------- All books in the store --------------");
        System.out.println(allBooks);

        // All bicycles in the store
        String allBicycles = JsonPath.read(jsonString, "$..bicycle").toString();
        System.out.println("--------------- All bicycles in the store ---------------");
        System.out.println(allBicycles);

        // The number of books
        String noOfBooks = JsonPath.read(jsonString, "$..book.length()").toString();
        System.out.println("--------------- All bicycles in the store ---------------");
        System.out.println(allBicycles);

        // The authors of all books
        String authors = JsonPath.read(jsonString, "$.store.book[*].author").toString();
        System.out.println("--------------- Author of all Books ---------------");
        System.out.println(authors);

// All authors
        String allAuthors = JsonPath.read(jsonString, "$..author").toString();
        System.out.println("--------------- All Authors ---------------");
        System.out.println(allAuthors);

// All details of the store
        String store = JsonPath.read(jsonString, "$.store.*").toString();
        System.out.println("--------------- All details of the store ---------------");
        System.out.println(store);

// Price of store
        String storePrice = JsonPath.read(jsonString, "$.store..price").toString();
        System.out.println("--------------- price of store ---------------");
        System.out.println(storePrice);

        // Third book
        String thirdBook = JsonPath.read(jsonString, "$..book[2]").toString();
        System.out.println("--------------- third book ---------------");
        System.out.println(thirdBook);

// first Last Book
        String firstLastBook = JsonPath.read(jsonString, "$..book[-1]").toString();
        System.out.println("--------------- first Last Book ---------------");
        System.out.println(firstLastBook);

// first two Books
        String firstTwoBooks = JsonPath.read(jsonString, "$..book[0,1]").toString();
        System.out.println("--------------- first Two Books ---------------");
        System.out.println(firstTwoBooks);

// books from index 0 (inclusive) until index 2 (exclusive)
        String booksRange = JsonPath.read(jsonString, "$..book[:2]").toString();
        System.out.println("--------------- books from index 0 (inclusive) until index 2 (exclusive) ---------------");
        System.out.println(booksRange);

// All books from index 1 (inclusive) until index 2 (exclusive)
        String booksRange1 = JsonPath.read(jsonString, "$..book[1:2]").toString();
        System.out.println("------------ All books from index 1 (inclusive) until index 2 (exclusive) -----------");
        System.out.println(booksRange1);

// Book number one from tail
        String bottomBook = JsonPath.read(jsonString, "$..book[1:]").toString();
        System.out.println("--------------- Book number one from tail ---------------");
        System.out.println(bottomBook);

        // All books in store expensive than 10
        String expensiveBook = JsonPath.read(jsonString, "$.store.book[?(@.price > 10)]").toString();
        System.out.println("--------------- All books in store costlier than 10 ---------------");
        System.out.println(expensiveBook);

// All books in store that are not "expensive"
        String notExpensiveBook = JsonPath.read(jsonString, "$..book[?(@.price <= $['expensive'])]").toString();
        System.out.println("--------------- All books in store that are not expensive ---------------");
        System.out.println(notExpensiveBook);

// All books in store that are equal to price 8.95
        String comparePrice = JsonPath.read(jsonString, "$.store.book[?(@.price == 8.95)]").toString();
        System.out.println("--------------- All books in store that are not expensive ---------------");
        System.out.println(comparePrice);

// All books matching regex (ignore case)
        String regxExample = JsonPath.read(jsonString, "$..book[?(@.author =~ /.*REES/i)]").toString();
        System.out.println("--------------- All books matching regex (ignore case) ---------------");
        System.out.println(regxExample);

// All books with price equal to mentioned list of prices
        String priceList = JsonPath.read(jsonString, "$..book[?(@.price in ['12.99', '8.99'])]").toString();
        System.out.println("--------------- All books with price equal to mentioned list of prices ---------------");
        System.out.println(priceList);

// All books with price NOT equal to mentioned list of prices
        String excludePriceList = JsonPath.read(jsonString, "$..book[?(@.price nin ['12.99', '8.99'])]").toString();
        System.out.println("---------- All books with price NOT equal to mentioned list of prices ---------");
        System.out.println(excludePriceList);

// All books with specified substring (case-sensitive)
        String substringExample = JsonPath.read(jsonString, "$..book[?(@.author contains 'Melville')]").toString();
        System.out.println("--------------- All books with specified substring (case-sensitive) ---------------");
        System.out.println(substringExample);

// All books with an ISBN number
        String specificBook = JsonPath.read(jsonString, "$..book[?(@.isbn)]").toString();
        System.out.println("--------------- All books with an ISBN number ---------------");
        System.out.println(specificBook);
    }
}
