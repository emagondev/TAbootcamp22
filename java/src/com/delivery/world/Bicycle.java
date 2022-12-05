package com.delivery.world;

public class Bicycle extends Vehicle {

	public Bicycle(String modelName, int speed, int maxSpeed) {
		// TODO Auto-generated constructor stub
		super(modelName, speed, maxSpeed);
	}

	@Override
	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed > 70) {
			super.setMaxSpeed(70);
		} else {
			super.setMaxSpeed(maxSpeed);
		}
	}

}
