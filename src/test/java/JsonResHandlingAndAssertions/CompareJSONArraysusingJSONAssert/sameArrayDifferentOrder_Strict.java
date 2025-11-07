package JsonResHandlingAndAssertions.CompareJSONArraysusingJSONAssert;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class sameArrayDifferentOrder_Strict {
    public static void main(String[] args) {

        String jsonArray1 = "[\"faizan\",\"abc\",\"safa\"]";
        String jsonArray2 = "[\"addu\",\"pqr\",\"safa\"]";

        JSONAssert.assertEquals(jsonArray1, jsonArray2, JSONCompareMode.STRICT);
    }

}

