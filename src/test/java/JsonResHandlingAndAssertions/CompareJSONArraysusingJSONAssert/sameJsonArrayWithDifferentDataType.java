package JsonResHandlingAndAssertions.CompareJSONArraysusingJSONAssert;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class sameJsonArrayWithDifferentDataType {
    public static void main(String[] args) {
        String jsonArray1 = "[\"faizan\",\"abc\",\"145000\"]";
        String jsonArray2 = "[\"faizan\",\"abc\",145000]";

        JSONAssert.assertEquals(jsonArray1, jsonArray2, JSONCompareMode.LENIENT);
    }
}
