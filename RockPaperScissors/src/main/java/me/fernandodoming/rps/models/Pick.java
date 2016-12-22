package me.fernandodoming.rps.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Coded by Fernando on 22/12/2016.
 * An enum class to enumerate possible hand types
 */
public enum Pick {
    ROCK(1), PAPER(2), SCISSORS(3);

    // An integer value to be able to "instantiate" an enum
    // element from a value
    private int rawValue;
    // As enum1s can not be instantiated an equivalence Map is needed
    private static Map<Integer, Pick> map = new HashMap<>();

    static {
        for (Pick pick : Pick.values()) {
            map.put(pick.rawValue, pick);
        }
    }

    Pick(int rawValue) {
        this.rawValue = rawValue;
    }

    public int getRawValue() {
        return rawValue;
    }

    /**
     * Get a Pick element by it's value
     * @param rawValue The value corresponding to the element
     * @return The Pick enum element
     * */
    public static Pick valueOf(int rawValue) {
        return map.get(rawValue);
    }

    /**
     * Get a random Pick
     * @return A random Pick element
    * */
    public static Pick getRandom() {
        int random = new Random().nextInt(3) + 1;
        return Pick.valueOf(random);
    }

    public boolean beats(Pick another) {
        return (this == ROCK && another == SCISSORS ||
                this == PAPER && another == ROCK ||
                this == SCISSORS && another == PAPER);
    }
}
