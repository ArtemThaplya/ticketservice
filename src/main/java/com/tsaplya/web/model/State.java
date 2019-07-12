package com.tsaplya.web.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum State {
    INPPROGRESS, ERROR, DONE;

    private static final List<State> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static State randomSate() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
