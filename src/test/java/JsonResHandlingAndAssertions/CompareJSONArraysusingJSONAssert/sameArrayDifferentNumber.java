package JsonResHandlingAndAssertions.CompareJSONArraysusingJSONAssert;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class sameArrayDifferentNumber {
    public static void main(String[] args) {
        String jsonArray1 = "[\"faizan\",\"abc\",\"safa\", \"bob\"]";
        String jsonArray2 = "[\"faizan\",\"abc\",\"safa\"]";

        JSONAssert.assertEquals(jsonArray1, jsonArray2, JSONCompareMode.LENIENT);
    }
}
