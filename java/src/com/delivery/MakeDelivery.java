package com.delivery;

import java.util.Iterator;

import com.delivery.persons.Client;
import com.delivery.persons.DeliveryPerson;

public class MakeDelivery {

	public MakeDelivery() {
		// TODO Auto-generated constructor stub

		// argument: time,

	}

	public float calculatePrice(PackageToDeliver item) {
		float amountPerKg = 350.00f;
		float value = 0f;
		value += item.getWeight() * amountPerKg;
		return value;

	}

//	public void deliverAPackage(PackageToDeliver item, DeliveryPerson delivery, Client client, String location) {
//		System.out.println("START The delivery is now at " + delivery.getLocationOrigin());
//	}

	public void addOrder(Client client, DeliveryPerson delivery, PackageToDeliver item) {
		/* TODO check if the item isn't already one the order */

		delivery.getOrderlist().addOrder(item);

		System.out.println("Delivery " + delivery.getFirstName() + " is on his way to delivery" + item.getItemName()
				+ " to " + item.getDestination());
		delivery.setState("delivering");
		delivery.setWallet(calculatePrice(item));
//		System.out.println(delivery.toString());

	}

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

}
