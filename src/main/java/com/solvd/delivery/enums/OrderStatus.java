package com.solvd.delivery.enums;

public enum OrderStatus {

    ORDERED(5) {
        @Override
        public boolean isOrdered() {
            return true;
        }
    },
    READY(2) {
        @Override
        public boolean isReady() {
            return true;
        }
    },
    DELIVERED(0) {
        @Override
        public boolean isDelivered() {
            return true;
        }
    },
    CANCELED(-1) {
        @Override
        public boolean isCanceled() {
            return true;
        }

    };

    private int timeToDelivery;

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

    OrderStatus(int timeToDelivery) {
        this.timeToDelivery = timeToDelivery;
    }

}

