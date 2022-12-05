package com.delivery;

import java.util.Objects;

public class PackageToDeliver {
	private String itemName;
	private double weight; // in kg
	private long clientPhone;
	private int quantity;
	private String destination;
	private int distanceInMeters;

	public PackageToDeliver() {
		this.itemName = null;
		this.weight = 0;
		this.clientPhone = 0;
		this.quantity = 0;
		this.destination = null;
	}

	public PackageToDeliver(String itemName, double weight, long clientPhone, int quantity, String destination,
			int distanceInMeters) {
		this.itemName = itemName;
		this.weight = weight;
		this.clientPhone = clientPhone;
		this.setQuantity(quantity);
		this.destination = destination;
		this.setDistanceInMeters(distanceInMeters);
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

	public long getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(long clientPhone) {
		this.clientPhone = clientPhone;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistanceInMeters() {
		return distanceInMeters;
	}

	public void setDistanceInMeters(int distanceInMeters) {
		this.distanceInMeters = distanceInMeters;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientPhone, destination, itemName, quantity, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackageToDeliver other = (PackageToDeliver) obj;
		return clientPhone == other.clientPhone && Objects.equals(destination, other.destination)
				&& Objects.equals(itemName, other.itemName) && quantity == other.quantity
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

}
