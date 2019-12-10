package com.brent.comparison.fixtures;

import java.util.HashMap;
import java.util.Map;

public class CharacteristicsFixture {

    public static Map<String, String> aDefaultCharacteristics() {
        Map<String, String> characteristics = new HashMap<>();
        characteristics.put("Stuff", "Things");
        characteristics.put("Bront", "NotBront");
        return characteristics;
    }
}
