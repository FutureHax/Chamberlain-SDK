package com.futurehax.chamberlainsdk.models;

/**
 * Created by Ken Kyger on 8/21/15.
 * Github - r2DoesInc
 * Email - r2DoesInc@futurehax.com
 */
public enum DoorState {
    OPEN(1, "Open"),
    CLOSED(2, "Closed"),
    UNKNOWN(3, "Unknown"),
    OPENING(4, "Opening"),
    CLOSING(5, "Closing");

    int attributeValue;
    String value;

    DoorState(int attributeValue, String value) {
        this.attributeValue = attributeValue;
        this.value = value;
    }


    public static DoorState getState(int state) {
        for (DoorState s : values()) {
            if (s.attributeValue == state) {
                return s;
            }
        }

        return UNKNOWN;
    }

    public static DoorState getState(String state) {
        for (DoorState s : values()) {
            if (s.value.equalsIgnoreCase(state)) {
                return s;
            }
        }

        return UNKNOWN;    }

    public String getState() {
        return value;
    }

    public int getValue() {
        return attributeValue;
    }
}
