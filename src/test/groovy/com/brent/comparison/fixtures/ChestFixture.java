package com.brent.comparison.fixtures;

import com.brent.comparison.builders.ChestBuilder;

public class ChestFixture {

    public static ChestBuilder aDefaultChest(){
        return ChestBuilder.aChest()
                .withNumOfThings(42.00)
                .withRunningOutOfAttributes(true);
    }
}
