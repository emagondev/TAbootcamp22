package com.solvd.delivery;

import com.solvd.delivery.world.Location;

import java.util.Arrays;
import java.util.Objects;


public class PackageToDeliver {


    private String itemName;
    private double weight; // in kg
    private String clientPhone;
    private int quantity;
    private Location destination;

    public PackageToDeliver() {
        this.itemName = null;
        this.weight = 0;
        this.clientPhone = "";
        this.quantity = 0;
        this.destination = new Location();


    }

    public PackageToDeliver(String itemName, double weight, String clientPhone, int quantity, Location destination) {
        this.itemName = itemName;
        this.weight = weight;
        this.clientPhone = clientPhone;
        this.setQuantity(quantity);
        this.destination = destination;

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Location getDestination() {
        return destination;
    }

    public double getDestinationX() {
        return destination.getCoordinateX();
    }

    public double getDestinationY() {
        return destination.getCoordinateY();
    }

    public void setDestination(Location location) {
        this.destination = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageToDeliver that = (PackageToDeliver) o;
        return Double.compare(that.weight, weight) == 0 && quantity == that.quantity && itemName.equals(that.itemName) && clientPhone.equals(that.clientPhone) && destination.equals(that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, weight, clientPhone, quantity, destination);
    }

    @Override
    public String toString() {
        return "PackageToDeliver{" +
                "itemName='" + itemName + '\'' +
                ", weight=" + weight +
                ", clientPhone='" + clientPhone + '\'' +
                ", quantity=" + quantity +
                ", destination=" + destination +
                '}';
    }
}
