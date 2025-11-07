package JsonResHandlingAndAssertions.CompareJSONArraysusingJSONAssert;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class sameArrayCaseSensitive {
    public static void main(String[] args) {
        String jsonArray1 = "[\"faIZan\",\"aBc\",\"safa\"]";
        String jsonArray2 = "[\"faizan\",\"abc\",\"safa\"]";
        JSONAssert.assertEquals(jsonArray1, jsonArray2, JSONCompareMode.LENIENT);
    }
}
