package com.delivery.persons;

import com.delivery.PackageToDeliver;

public class Client extends Person {

	PackageToDeliver packageToDeliver;
	String state;
	int deliverId;
	String location;
	PackageToDeliver paquete = new PackageToDeliver();

	public Client(String firstName, String lastName, long phone, long wallet, PackageToDeliver packageToDeliver,
			String state, int deliverId, String location) {
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

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation(String location) {
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

	@Override
	public String toString() {
		return String.format("[%s] %s, %i, %f", this.state, this.packageToDeliver, this.deliverId);
	}
}
