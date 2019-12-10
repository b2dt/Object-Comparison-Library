package com.brent.comparison.fixtures;

import com.brent.comparison.testData.Toe;

import java.util.HashMap;
import java.util.Map;

public class TestDetailsFixture {

    public static Map<String, Toe> aDefaultTestDetail() {
        Map<String, Toe> details = new HashMap<>();
        details.put("TOESSS", ToeFixture.aDefaultToe().build());
        details.put("someToes", ToeFixture.aDefaultToe().withHasNail(false).build());
        return details;
    }

}
