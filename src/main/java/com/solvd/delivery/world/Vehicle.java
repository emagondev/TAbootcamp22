package com.solvd.delivery.world;

import java.util.Objects;
public class Vehicle {

    private String modelName;
    private int speed;
    private int maxSpeed;

    public Vehicle(String modelName, int speed, int maxSpeed) {
        this.modelName = modelName;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void speedUp(int increment) {
        this.speed += increment;
    }

    public void speedDown(int decrement) {
        this.speed -= decrement;
    }


}
