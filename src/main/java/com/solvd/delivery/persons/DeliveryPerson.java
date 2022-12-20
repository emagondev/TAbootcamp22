package com.solvd.delivery.persons;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

import com.solvd.delivery.PackageToDeliver;
import com.solvd.delivery.interfaces.IPay;
import com.solvd.delivery.world.Vehicle;

public class DeliveryPerson extends Person implements IPay {
    private String state;
    // waiting / on deliver
    private double[] locationCurrent;

    private double[] locationDestination;
    private int deliverId;

    private LinkedList<PackageToDeliver> itemList = new LinkedList<>();
    private Vehicle vehicle;

    public DeliveryPerson() {
        super(null, null, "", 0);
        this.state = null;
        this.locationCurrent = new double[2];
        this.locationDestination = new double[2];
        this.deliverId = 0;
        this.vehicle = null;
    }

    public DeliveryPerson(String firstName, String lastName, String phone, long wallet, String state,
                          double[] locationCurrent, double[] locationDestination, int deliverId, Vehicle vehicle) {

        super(firstName, lastName, phone, wallet);
        this.state = state;
        this.locationCurrent = locationCurrent;
        this.locationDestination = locationDestination;
        this.deliverId = deliverId;
        this.vehicle = vehicle;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double[] getLocationCurrent() {

        return locationCurrent;
    }

    public double getLocationOriginX() {
        return locationCurrent[0];
    }

    public double getLocationOriginY() {
        return locationCurrent[1];
    }

    public void setLocationCurrent(double[] location) {

        this.locationCurrent = location;
    }

    public double[] getLocationDestination() {

        return locationDestination;
    }

    public void setLocationDestination(double[] locationDestination) {

        this.locationDestination = locationDestination;
    }

    public int getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(int deliverId) {
        this.deliverId = deliverId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void getOrderData() {
        System.err.println("Delivery " + this.getFirstName() + " " + this.getLastName() + " order queue:");
        System.out.println("\n Delivery name: " + this.getFirstName());
        if (this.itemList.size() == 0) {
            System.out.println("List order is empty");
        } else {
            for (PackageToDeliver packageToDeliver : itemList) {
                System.out.println("|Item: " + packageToDeliver.getItemName() + " |Weight: "
                        + packageToDeliver.getWeight() + "kgs  " + "|Client contact "
                        + packageToDeliver.getClientPhone() + "| Quantity: " + packageToDeliver.getQuantity() + "|");
                System.out.println("-----------------------");
            }
        }

    }

    public void addPackage(PackageToDeliver item) {
        itemList.add(item);
    }

    public void addListOfPackages(LinkedList<PackageToDeliver> listToAdd) {
        itemList.addAll(listToAdd);
    }

    public void removePackage(PackageToDeliver item) {
        try {
            itemList.remove(item);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Package " + item.getItemName() + " not found");
        }
    }

    public PackageToDeliver accessPackage(int i) {
        return itemList.get(i);
    }

    public LinkedList<PackageToDeliver> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {
        return String.format("Delivery name: %s %s     Phone: %d, Wallet %.2f  State: %s Vehicle: %s Speed: %d",
                super.getFirstName(), super.getLastName(), super.getPhone(), super.getWallet(), state,
                this.getVehicle().getModelName(), this.getVehicle().getSpeed());

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + Objects.hash(deliverId, Arrays.hashCode(locationDestination), Arrays.hashCode(locationCurrent), itemList, state, vehicle);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeliveryPerson other = (DeliveryPerson) obj;
        return deliverId == other.deliverId && Objects.equals(locationDestination, other.locationDestination)
                && Objects.equals(locationCurrent, other.locationCurrent) && Objects.equals(itemList, other.itemList)
                && Objects.equals(state, other.state) && Objects.equals(vehicle, other.vehicle);
    }

    @Override
    public void waitDelivery() {
        this.state = "working";
    }

    @Override
    public float calculatePrice(double distance) {
        return 0;
    }

    @Override
    public void getPaid(float cash) {
        this.setWallet((this.getWallet() + cash));
    }

    @Override
    public void pay(float cash) {
    }
}
