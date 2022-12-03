package com.delivery.world;

import java.util.Objects;

public class Car extends Vehicle {

	private int currentFuel;

	public Car(String modelName, int speed, int maxSpeed, int currentFuel) {
		super(modelName, speed, maxSpeed);
		this.currentFuel = currentFuel;
		// TODO Auto-generated constructor stub
	}

	public int getCurrentFuel() {
		return currentFuel;
	}
	
	public void setCurrentFuel(int currentFuel) {
		this.currentFuel = currentFuel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(currentFuel);
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
		Car other = (Car) obj;
		return currentFuel == other.currentFuel;
	}

	@Override
	public String toString() {
		return String.format("Vehicle: %s, Current speed:%d, Max Speed: %d %n Current fuel: %int liters",
				super.getModelName(), super.getSpeed(), this.currentFuel);

	}

}
