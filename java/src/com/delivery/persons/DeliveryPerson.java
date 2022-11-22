package com.delivery.persons;

import com.delivery.Orders;

	

public class DeliveryPerson extends Person{
	
	
	private String state;
	// waiting / on deliver
	private String locationOrigin;
	private String locationDestination;
//	private PackageToDeliver[] packageToDeliver;
//	private ArrayList<PackageToDeliver> packageList = new ArrayList<>();
//	private Orders packageList;
	private int deliverId;
	private Orders orderlist;
//	private Orders orderlist = new Orders();
	
	public DeliveryPerson(String firstName, String lastName, long phone, long wallet, String state, String locationOrigin, String locationDestination, /*ArrayList<PackageToDeliver> packageList*/ Orders orderlist, int deliverId) {
		super(firstName, lastName, phone, wallet);
		setState(state);
		setLocationOrigin(locationOrigin);
		setLocationDestination(locationDestination);
//		setPackageToDeliver(packageList);
		setOrderlist(orderlist);
		setDeliverId(deliverId);
		
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

/*
	public Orders getPackageList() {
		return packageList;
	}

	public void setPackageList(Orders packageList) {
		this.packageList = packageList;
	}
	
	
	*/

/*	
	public ArrayList<PackageToDeliver> getPackageToDeliverList(){
		return packageList;
	}
	
	public void setPackageToDeliver(PackageToDeliver packageToDeliver) {
		this.packageToDeliver = packageToDeliver;
	}
	public PackageToDeliver getPackagetodeliver() {
		return packageToDeliver;
		
	}
*/
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
	
	@Override
	public String toString() {
		return String.format("[%s] %s, %i, %f", state, locationOrigin, locationDestination, orderlist, deliverId);
	}

	public String getOrderData() {
		return "Package content: "+ this.orderlist.getPackageList().get(0).getItemName() +
				"\nIt weights: "+ this.orderlist.getPackageList().get(0).getWeight() + "kgs \n" +
				"Client contact "+ this.orderlist.getPackageList().get(0).getClientPhone();
		
	}
	
	
	public void makeDelivery() {
//		if(this.getOrderlist().access(deliverId))
		if(this.getLocationOrigin().compareTo(this.getLocationDestination()) != 0 )  {
			this.locationOrigin = this.locationDestination;
			
		}
		
	}


}
