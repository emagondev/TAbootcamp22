package com.solvd.delivery.persons;

import com.solvd.delivery.world.Location;

import java.util.Objects;

public abstract class Person {

    private String firstName;
    private String lastName;
    private String phone;
    private float wallet;
    private Location location = new Location(0, 0);

    public Person() {

    }

    public Person(String firstName, String lastName, String phone, float wallet, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.wallet = wallet;
        this.location = location;
    }

    // abstract method
    public abstract void waitDelivery();
    // ----

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location loc) {
        this.location = loc;
    }

    /*
        public void setLocation(Location locationN) {
            location.setCoordinateY(locationN.getCoordinateY());
            location.setCoordinateX(locationN.getCoordinateX());
            this.location = location;
        }
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Float.compare(person.wallet, wallet) == 0 && firstName.equals(person.firstName) && lastName.equals(person.lastName) && phone.equals(person.phone) && location.equals(person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phone, wallet, location);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", wallet=" + wallet +
                ", location=" + location +
                '}';
    }
}
