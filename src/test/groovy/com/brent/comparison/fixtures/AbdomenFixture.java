package com.brent.comparison.fixtures;

import com.brent.comparison.builders.AbdomenBuilder;

public class AbdomenFixture {

    public static AbdomenBuilder aDefaultAbdomen() {
        return AbdomenBuilder.anAbdomen()
                .withAreDefined(false)
                .withNumOfAbs(1);
    }
}
