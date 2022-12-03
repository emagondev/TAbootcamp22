package com.delivery;


import com.delivery.persons.*;
import com.delivery.world.Time;

public class DeliveryService {
	Time currentTime = new Time(800);
	// TODO each delivery needs an Orders object - fix


	
	public DeliveryService() {
	}



	public void deliveryTest(DeliveryPerson delivery) {
		PackageToDeliver[] listOfItems = { new PackageToDeliver("Item1", 1, 100000, 1, "Street 70"),
				new PackageToDeliver("Item2", 1, 100000, 1, "Street 70"),
				new PackageToDeliver("Item3", 2, 100000, 1, "Street 70") };
		for (PackageToDeliver item : listOfItems) {
			delivery.addPackage(item);
		}

	}

	public void deliverAPackage(PackageToDeliver item, DeliveryPerson delivery, Client client) {
		currentTime.whatTime();
		System.out.println("START The delivery is now at " + delivery.getLocationOrigin());

		// TODO method to calculate price
		float price = 500f;
		System.out.println(client.toString());
		System.out.println("Asks delivery " + delivery.getFirstName() + " to take " + item.getItemName() + " to "
				+ item.getDestination());
		addOrder(client, delivery, item);
		
		delivery.getOrderData();
		currentTime.setHoursminute(60);
		currentTime.whatTime();
		System.out.println(": Arrived");
		
		delivery.setLocationOrigin(item.getDestination());
//		makedelivery.deleteOrder(client, delivery);
		delivery.removePackage(item);
		changeWallets(delivery, client, price);

		// TODO method that calculates the price with the weight of the order
//		System.out.println("The delivery is now at " + deliveryJ.getLocationOrigin());
//		System.out.println("Delivery order queue:");
//		delivery.getOrderData();
//		System.out.println("-------------------------------------------------------3-");

	}

	public void changeWallets(DeliveryPerson d, Client c, float price) {

		c.setWallet(c.getWallet() - price);
		d.setWallet(d.getWallet() + price);
		System.out.println("\nDelivery " + d.getFirstName() + " got paid " + price + " pesos");
		System.out.println("Now he has: " + d.getWallet() + "\n");

	}
	
	public float calculatePrice(PackageToDeliver item) {
		float amountPerKg = 350.00f;
		float value = 0f;
		value += item.getWeight() * amountPerKg;
		return value;

	}
	
	public void addOrder(Client client, DeliveryPerson delivery, PackageToDeliver item) {
		/* TODO check if the item isn't already one the order */

		delivery.addPackage(item);
		System.out.println("Delivery " + delivery.getFirstName() + " is on his way to delivery" + item.getItemName()
				+ " to " + item.getDestination());
		delivery.setState("delivering");
		delivery.setWallet(calculatePrice(item));
//		System.out.println(delivery.toString());

	}

	/*
	public void deleteOrder(Client client, DeliveryPerson delivery) {
		// Creating iterator object
		Iterator<com.delivery.PackageToDeliver> itr = delivery.getOrderlist().getPackageList().iterator();
		while (itr.hasNext()) {

			// remove element if client phone == packageToDeliver phone
			PackageToDeliver x = (PackageToDeliver) itr.next();
			if (x.getClientPhone() == client.getPhone()) {
				itr.remove();
			}

		}
		
	}
	*/
	
	

}
