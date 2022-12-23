package com.solvd.delivery.persons;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

import com.solvd.delivery.PackageToDeliver;
import com.solvd.delivery.interfaces.IPay;
import com.solvd.delivery.world.Location;
import com.solvd.delivery.world.Vehicle;

public class DeliveryPerson extends Person implements IPay {
    private String state;
    // waiting / on deliver
    private Location locationDestination;
    private int deliverId;

    private LinkedList<PackageToDeliver> itemList = new LinkedList<>();
    private Vehicle vehicle;

    public DeliveryPerson() {
        super(null, null, "", 0, new Location());
        this.locationDestination = new Location();
        this.state = null;
        this.deliverId = 0;
        this.vehicle = null;
    }

    public DeliveryPerson(String firstName, String lastName, String phone, long wallet, Location location,
                          Location locationDestination, String state,
                          int deliverId, Vehicle vehicle) {

        super(firstName, lastName, phone, wallet, new Location());
        this.locationDestination = locationDestination;
        this.state = state;
        this.deliverId = deliverId;
        this.vehicle = vehicle;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Location getLocationDestination() {
        return locationDestination;
    }

    public void setLocationDestination(Location locationDestination) {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeliveryPerson that = (DeliveryPerson) o;
        return deliverId == that.deliverId && state.equals(that.state) && locationDestination.equals(that.locationDestination) && itemList.equals(that.itemList) && vehicle.equals(that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), state, locationDestination, deliverId, itemList, vehicle);
    }

    @Override
    public String toString() {
        return "DeliveryPerson{" +
                "state='" + state + '\'' +
                ", locationDestination=" + locationDestination +
                ", deliverId=" + deliverId +
                ", itemList=" + itemList +
                ", vehicle=" + vehicle +
                '}';
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
