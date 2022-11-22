package com.delivery;

public class PackageToDeliver {
	private String itemName;
	private double weight; //in kg
	private long clientPhone;

	
	public PackageToDeliver() {
		
	}
	
	public PackageToDeliver(String itemName, double weight, long clientPhone) {
		this.itemName = itemName;
		this.weight = weight;
		this.clientPhone = clientPhone;
		
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

}
