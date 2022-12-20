package com.solvd.delivery.enums;

public enum DeliveryTier {

    //enum constants
    MAXVALUE(Integer.MAX_VALUE),
    HIGH(120),
    MEDIUM(80),
    LOW(60),
    MINVALUE(Integer.MIN_VALUE);

    public final int value;

    //private enum constructor
    DeliveryTier(final int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }
}
