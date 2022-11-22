package com.delivery.persons;

import com.delivery.PackageToDeliver;

public class Client extends Person{
	
	PackageToDeliver packageToDeliver;
	String state;
	int deliverId;
	String location;
//	Person person = new Person();
	PackageToDeliver paquete = new PackageToDeliver();
	
//	public Client(String string, String string2, int i, double d, String string3, PackageToDeliver packageToDeliver2){
//	}
	
	
	public Client (String firstName, String lastName, long phone, long wallet, PackageToDeliver packageToDeliver, String state, int deliverId, String location){
		super(firstName, lastName, phone, wallet);
//		setState(state);
		this.state = state;
		//idle, waiting to be delivered
//		setDeliverId(deliverId);
		this.deliverId = deliverId;
//		setLocation(location);
		this.location = location;
//		setPackageToDeliver(packageToDeliver);
		this.packageToDeliver = packageToDeliver;
	}
//	
//	public Client(Client aClient) {
//		this.setFirstName(aClient.getFirstName());
//		this.setLastName(aClient.getLastName());
//		this.setPhone(aClient.getPhone());
//		this.setWallet(aClient.getWallet());
//		this.packageToDeliver = aClient.packageToDeliver;
//		this.state = aClient.state;
//		this.deliverId = aClient.deliverId;
//		this.location = aClient.location;
//		
//	}

	

	



//
//	public Client(String string, String string2, int i, Object object, Object object2, int j, int k, Object object3,
//			PackageToDeliver packageToDeliver2) {
//		// TODO Auto-generated constructor stub
//	}









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
