package com.delivery.persons;

import java.util.Objects;

import com.delivery.Orders;
import com.delivery.world.Vehicle;

public class DeliveryPerson extends Person {



	private String state;
	// waiting / on deliver
	private String locationOrigin;
	private String locationDestination;
	private int deliverId;
	private Orders orderlist;
	private Vehicle vehicle;

	public DeliveryPerson(String firstName, String lastName, long phone, long wallet, String state, String locationOrigin, String locationDestination, Orders orderlist, int deliverId, Vehicle vehicle) {
		
		super(firstName, lastName, phone, wallet);
		this.state = state;
		this.locationOrigin = locationOrigin;
		this.locationDestination =locationDestination;
//		setPackageToDeliver(packageList);
		this.orderlist = orderlist;
		this.deliverId = deliverId;
		this.vehicle= vehicle;
		
		

	}

//	public String getDeliveryPackage() {
//		return DeliveryPackage;
//	}
//
//	public void setDeliveryPackage(String deliveryPackage) {
//		DeliveryPackage = deliveryPackage;
//	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocationOrigin() {
		return locationOrigin;
	}

	public void setLocationOrigin(String location) {
		this.locationOrigin = location;
	}

	public String getLocationDestination() {
		return locationDestination;
	}

	public void setLocationDestination(String locationDestination) {
		this.locationDestination = locationDestination;
	}

	public int getDeliverId() {
		return deliverId;
	}

	public void setDeliverId(int deliverId) {
		this.deliverId = deliverId;
	}

	public Orders getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(Orders orderlist) {
		this.orderlist = orderlist;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	

	
	

	public void getOrderData(){
		/*
		 * Checks if list order of packages is empty and prints what it contains
		 * 
		 * */
		String name = this.getFirstName() +" "+ this.getLastName();
		System.out.println("\n Delivery name: "+ name);
		if(this.orderlist.getPackageList().size() == 0) {
			System.out.println("List order is empty");
		} else {
		for(int i =0; i< this.orderlist.getPackageList().size();i++) {
			System.out.println("|Item: " + this.orderlist.getPackageList().get(i).getItemName() + " |Weight: " + this.orderlist.getPackageList().get(i).getWeight() + "kgs  " + "|Client contact " + this.orderlist.getPackageList().get(i).getClientPhone() + "| Quantity: "+ this.orderlist.getPackageList().get(i).getQuantity() +"|");
			System.out.println("-----------------------");
		}
			
	
			}
	}

	
	
//	public void makeDelivery() {
//		//TODO not used
//		if (this.getLocationOrigin().compareTo(this.getLocationDestination()) != 0) {
//			this.locationOrigin = this.locationDestination;
//			
//		}
//
//	}
	
	
	@Override
	public String toString() {
		return String.format("Delivery name: %s %s     Phone: %d, Wallet %.2f  State: %s Vehicle: %s Speed: %d", super.getFirstName(), super.getLastName(), super.getPhone(), super.getWallet(), state, this.getVehicle().getModelName(), this.getVehicle().getSpeed() );
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(deliverId, locationDestination, locationOrigin, orderlist, state, vehicle);
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
		DeliveryPerson other = (DeliveryPerson) obj;
		return deliverId == other.deliverId && Objects.equals(locationDestination, other.locationDestination)
				&& Objects.equals(locationOrigin, other.locationOrigin) && Objects.equals(orderlist, other.orderlist)
				&& Objects.equals(state, other.state) && Objects.equals(vehicle, other.vehicle);
	}




}
