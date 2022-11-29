package com.delivery;

import com.delivery.persons.*;
import com.delivery.world.Car;
import com.delivery.world.ElectricScooter;
import com.delivery.world.Time;
import com.delivery.world.Vehicle;

public class DeliveryOp {
	Time currentTime = new Time(800);
	MakeDelivery makedelivery = new MakeDelivery();
	PackageToDeliver PackageToDeliver = new PackageToDeliver("Shoes", 1, 4123123, 1, "Street 70");
	PackageToDeliver packageOfClientA = new PackageToDeliver("Shoes", 1, 4123123, 1, "Street 70");

	PackageToDeliver shoes = new PackageToDeliver("Shoes", 1, 4123123, 1, "Street 50");
	PackageToDeliver flour = new PackageToDeliver("Flour", 1, 4123123, 1, "Street 70");
	PackageToDeliver trash = new PackageToDeliver("Bag of clothes", 2, 4123123, 1, "Street 70");

	Client clientA = new Client("Client1", "Black", 4123123, 1000, packageOfClientA, "idle", 0, "rosario");

	Orders orderlist = new Orders();
	Orders orderlistTest = new Orders();
	Vehicle carDeliA = new Car("Chevy", 0, 80, 120);
	Vehicle carTest = new ElectricScooter("XiaomiTest", 0, 20, 50);
	DeliveryPerson deliveryJ = new DeliveryPerson("John", "Doe", 12345, 500, "idle", "12 Street", "30 Street",
			orderlist, 1, carDeliA);
	DeliveryPerson deliveryT = new DeliveryPerson("TestName", "TestLName", 8000000, 1, "Idle", "Street 0", null,
			orderlistTest, 0, carTest);

	public DeliveryOp() {
	}

	public void oneDeliver() {


		deliverAPackage(flour, deliveryJ, clientA);

		// add dummy items
		PackageToDeliver[] listOfItems = { new PackageToDeliver("Item1", 1, 100000, 1, "Street 70"),
				new PackageToDeliver("Item2", 1, 100000, 1, "Street 70"),
				new PackageToDeliver("Item3", 2, 100000, 1, "Street 70") };
		for (PackageToDeliver item : listOfItems) {
			deliveryT.getOrderlist().addOrder(item);
		}


	}

	public void deliverAPackage(PackageToDeliver item, DeliveryPerson delivery, Client client) {
		currentTime.whatTime();
		System.out.println("START The delivery is now at " + delivery.getLocationOrigin());

		float price = 500f;
		System.out.println(client.toString());
		System.out.println("Asks delivery " + delivery.getFirstName() + " to take " + item.getItemName() + " to "
				+ item.getDestination());
		makedelivery.addOrder(client, delivery, item);
		System.err.println("Delivery order queue:");
		delivery.getOrderData();
		currentTime.setHoursminute(60);
		currentTime.whatTime();
		System.out.println(": Arrived");
		delivery.setLocationOrigin(item.getDestination());
		makedelivery.deleteOrder(client, delivery);
		changeWallets(delivery, client, price);
		// TODO method that calculates the price with the weight of the order
		System.out.println("The delivery is now at " + deliveryJ.getLocationOrigin());
		System.out.println("Delivery order queue:");
		delivery.getOrderData();
		System.out.println("--------------------------------------------------------");

	}

	public void changeWallets(DeliveryPerson d, Client c, float price) {

		c.setWallet(clientA.getWallet() - price);
		d.setWallet(deliveryJ.getWallet() + price);
		System.out.println("\nDelivery " + d.getFirstName() + " got paid " + price + " pesos");
		System.out.println("Now he has: " + d.getWallet());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
	}

}
