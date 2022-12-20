package com.solvd.delivery;

import java.util.Arrays;
import java.util.Objects;


public class PackageToDeliver {


    private String itemName;
    private double weight; // in kg
    private String clientPhone;
    private int quantity;
    private double[] destination;

    public PackageToDeliver() {
        this.itemName = null;
        this.weight = 0;
        this.clientPhone = "";
        this.quantity = 0;
        this.destination = new double[2];


    }

    public PackageToDeliver(String itemName, double weight, String clientPhone, int quantity, double[] destination) {
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

    public double[] getDestination() {
        return destination;
    }

    public double getDestinationX() {
        return destination[0];
    }

    public double getDestinationY() {
        return destination[1];
    }

    public void setDestination(double[] destination) {
        this.destination[0] = destination[0];
        this.destination[1] = destination[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageToDeliver that = (PackageToDeliver) o;
        return Double.compare(that.weight, weight) == 0 && clientPhone == that.clientPhone && quantity == that.quantity && itemName.equals(that.itemName) && Arrays.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(itemName, weight, clientPhone, quantity);
        result = 31 * result + Arrays.hashCode(destination);
        return result;
    }
}
