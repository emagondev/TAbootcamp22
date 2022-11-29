package com.delivery.persons;

import java.util.Objects;

import com.delivery.PackageToDeliver;

public class Client extends Person {

	PackageToDeliver packageToDeliver;
	String state;
	int deliverId;
	String location;
	PackageToDeliver paquete = new PackageToDeliver();
	
	public Client(String firstName, String lastName, long phone, float wallet, PackageToDeliver packageToDeliver,
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

	public String getLocation() {
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
		return String.format("%n%nClient name: %s %s \n Phone: %d, Wallet %.2f\n State: %s%n%n", super.getFirstName(),
				super.getLastName(), super.getPhone(), super.getWallet(), state);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(deliverId, location, packageToDeliver, paquete, state);
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
				&& Objects.equals(packageToDeliver, other.packageToDeliver) && Objects.equals(paquete, other.paquete)
				&& Objects.equals(state, other.state);
	}
	
	
}
