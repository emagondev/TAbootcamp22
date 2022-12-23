package com.solvd.delivery.enums;

public enum OrderStatus {

    ORDERED(5, true, false, false, false),
    READY(2, false, true, false, false),
    DELIVERED(0, false, false, true, false),
    CANCELED(-1, false, false, false, true);

    private int timeToDelivery;
    private boolean isOrdered;
    private boolean isReady;
    private boolean isDelivered;
    private boolean isCanceled;

    OrderStatus(int timeToDelivery, boolean isOrdered, boolean isReady, boolean isDelivered, boolean isCanceled) {
        this.timeToDelivery = timeToDelivery;
        this.isOrdered = isOrdered;
        this.isReady = isReady;
        this.isDelivered = isDelivered;
        this.isCanceled = isCanceled;
    }

    public boolean isOrdered() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public boolean isDelivered() {
        return false;
    }

    public boolean isCanceled() {
        return false;
    }

    public int getTimeToDelivery() {
        return timeToDelivery;
    }


}

