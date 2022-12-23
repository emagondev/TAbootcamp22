package com.solvd.delivery.world;

import java.util.Objects;

public class ElectricScooter extends Vehicle {


    private int battery;

    public ElectricScooter(String modelName, int speed, int maxSpeed, int battery) {
        // TODO Auto-generated constructor stub
        super(modelName, speed, maxSpeed);
        this.battery = battery;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

//    @Override
//    public String toString() {
//        return String.format("Scooter: %s, Current speed:%d, Max Speed: %d %n Current battery: %int liters",
//                super.getModelName(), super.getSpeed(), this.battery);
//    }

    @Override
    public String toString() {
        return "ElectricScooter{" +
                "battery=" + battery +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(battery);
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
        ElectricScooter other = (ElectricScooter) obj;
        return battery == other.battery;
    }

}
