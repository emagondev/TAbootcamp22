package com.delivery;

import com.delivery.persons.Client;
import com.delivery.persons.DeliveryPerson;
import com.delivery.world.Time;

public class MakeDelivery {

	public MakeDelivery() {
		// TODO Auto-generated constructor stub
		
		// argument: time, 
		
	}
	
	public void makeDelivery(Time time, DeliveryPerson delivery, Client client) {
		
	}
	
	public float calculatePrice(PackageToDeliver item){
		float amountPerKg = 350.00f;
		float value = 0f;
		value += item.getWeight() * amountPerKg;
		return value;
		
	}
	
	public void deliverAPackage(PackageToDeliver item, DeliveryPerson delivery, Client client) {
		
	}
	

}
