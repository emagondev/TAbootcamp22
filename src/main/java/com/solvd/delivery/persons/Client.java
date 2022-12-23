package com.solvd.delivery.persons;


import java.util.Objects;
import java.util.Scanner;

import com.solvd.delivery.PackageToDeliver;
import com.solvd.delivery.interfaces.IPay;
import com.solvd.delivery.world.Location;

public class Client extends Person implements IPay {
    private PackageToDeliver packageToDeliver;
    private String state;
    private int deliverId;


    public Client() {
        super(null, null, "", 0, new Location());
        this.state = "idle";
        this.packageToDeliver = null;
        this.state = null;
        this.deliverId = 0;

    }

    public Client(String firstName, String lastName, String phone, float wallet, Location location,
                  PackageToDeliver packageToDeliver,
                  String state, int deliverId) {

        super(firstName, lastName, phone, wallet, location);
        this.state = state;
        this.deliverId = deliverId;
        this.packageToDeliver = packageToDeliver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public void setPackageToDeliver(PackageToDeliver packageToDeliver) {
        this.packageToDeliver = packageToDeliver;
    }

    public PackageToDeliver getPackagetodeliver() {
        return packageToDeliver;

    }

    public int getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(int deliverID) {
        this.deliverId = deliverID;
    }


//    public void customizeClient() {
//        Scanner record = new Scanner(System.in);
//        System.out.println("First name: ");
//        String firstName = record.nextLine();
//        System.out.println("Last Name");
//        String lastName = record.nextLine();
//        System.out.println("Phone number:");
//        long phone = record.nextLong();
//        System.out.println("Money available: ");
//        float wallet = record.nextFloat();
//        record.nextLine();
//        System.out.println("Location: ");
//        String location = record.nextLine();
//        this.setFirstName(firstName);
//        this.setLastName(lastName);
//        this.setPhone(phone);
//        this.setWallet(wallet);
//        this.setLocation(location);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return deliverId == client.deliverId && packageToDeliver.equals(client.packageToDeliver) && state.equals(client.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packageToDeliver, state, deliverId);
    }

    @Override
    public String toString() {
        return "Client{" +
                "packageToDeliver=" + packageToDeliver +
                ", state='" + state + '\'' +
                ", deliverId=" + deliverId +
                '}';
    }

    @Override
    public void waitDelivery() {
        this.state = "waiting";

    }

    @Override
    public float calculatePrice(double distance) {
        return 0;
    }

    @Override
    public void getPaid(float cash) {
    }

    @Override
    public void pay(float cash) {
        this.setWallet(this.getWallet() - cash);
    }
}
