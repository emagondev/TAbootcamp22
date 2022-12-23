package com.solvd.delivery.enums;

public class Order {
    private OrderStatus status;


    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public boolean isDeliverable() {
        return Order.this.status.isReady();
//        return OrderStatus.OrderStatus.ORDERED.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to deliver is " +
                Order.this.status.getTimeToDelivery());
//                this.getStatus().getTimeToDelivery());
    }

    // Methods that set and get the status variable.
}
