package com.solvd.delivery.persons;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

import com.solvd.delivery.PackageToDeliver;
import com.solvd.delivery.interfaces.IPay;

public class Client extends Person implements IPay {
    private PackageToDeliver packageToDeliver;
    private String state;
    private int deliverId;
    private double[] location;


    public Client() {
        super(null, null, "", 0);
        this.state = "idle";
        this.packageToDeliver = null;
        this.state = null;
        this.deliverId = 0;
        this.location = new double[2];
    }

    public Client(String firstName, String lastName, String phone, float wallet, PackageToDeliver packageToDeliver,
                  String state, int deliverId, double[] location) {

        super(firstName, lastName, phone, wallet);
        this.state = state;
        this.deliverId = deliverId;
        this.location = location;
        this.packageToDeliver = packageToDeliver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public double[] getLocation() {
        return location;
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
    public String toString() {
        return "Client{" +
                "packageToDeliver=" + packageToDeliver +
                ", state='" + state + '\'' +
                ", deliverId=" + deliverId +
                ", location=" + Arrays.toString(location) +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(deliverId, Arrays.hashCode(location), packageToDeliver, state);
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
        Client other = (Client) obj;
        return deliverId == other.deliverId && Objects.equals(location, other.location)
                && Objects.equals(packageToDeliver, other.packageToDeliver) && Objects.equals(state, other.state);
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
