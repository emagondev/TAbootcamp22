package com.solvd.delivery.handlers;

import com.solvd.delivery.enums.OrderStatus;
import com.solvd.delivery.persons.Client;
import com.solvd.delivery.persons.DeliveryPerson;

public class Order {
    private OrderStatus status;
    private Client client;
    private DeliveryPerson deliveryPerson;

    private int tier;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

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

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", client=" + client +
                ", deliveryPerson=" + deliveryPerson +
                ", tier=" + tier +
                '}';
    }
    // Methods that set and get the status variable.
}
