package com.delivery;

import java.util.Iterator;

import com.delivery.persons.*;
import com.delivery.world.Car;
import com.delivery.world.Time;
import com.delivery.world.Vehicle;

public class DeliveryOp{
	Time currentTime = new Time(800);
	MakeDelivery makedelivery = new MakeDelivery();
	PackageToDeliver PackageToDeliver = new PackageToDeliver("Shoes", 1, 4123123,1, "Street 70");
	PackageToDeliver packageOfClientA = new PackageToDeliver("Shoes", 1, 4123123,1, "Street 70");
	
	PackageToDeliver shoes = new PackageToDeliver("Shoes", 1, 4123123,1, "Street 50");
	PackageToDeliver flour = new PackageToDeliver("Flour", 1, 4123123,1,"Street 70");
	PackageToDeliver trash = new PackageToDeliver("Bag of clothes", 2, 4123123,1,"Street 70");
	
	
	
	Client clientA = new Client("Client1", "Black", 4123123, 1000, packageOfClientA, "idle", 0, "rosario");
	
	Orders orderlist = new Orders();
	Vehicle carDeliA = new Car("Chevy",0,120,50);
	
	DeliveryPerson deliveryJ = new DeliveryPerson("John", "Doe", 12345, 500, "idle", "12 Street", "30 Street",
			orderlist, 01, carDeliA);

	public DeliveryOp() {
	}

	public void oneDeliver() {
		System.out.println(carDeliA.getModelName());
		
		System.out.println("START--- The delivery is now at " + deliveryJ.getLocationOrigin());
		int price = 500;

//		deliveryJ.getOrderlist().addOrder(packageOfClientA);
		
		System.out.println(clientA.toString());
		deliveryJ.getOrderData();;
		currentTime.whatTime();

		deliveryJ.getOrderData();
//		deliveryJ.getOrderlist().access(0);

		if (deliveryJ.getLocationOrigin().compareTo(deliveryJ.getLocationDestination()) != 0) {

			currentTime.setHoursminute(60);
			deliveryJ.setLocationOrigin(deliveryJ.getLocationDestination());
			changeWallets(deliveryJ, clientA, price);
			// TODO method that calculates the price with the weight of the order
			System.out.println("The delivery is now at " + deliveryJ.getLocationOrigin());

			currentTime.whatTime();

			// Todo currently each delivery takes 1 hour
		} else {
			System.out.println("The delivery is there");

		}
		
		//add dummy items
		PackageToDeliver[] listOfItems = {new PackageToDeliver("Item1", 1, 100000,1, "Street 70"),
				new PackageToDeliver("Item2", 1, 100000,1,"Street 70"),
				new PackageToDeliver("Item3", 2, 100000,1,"Street 70")
				};
		
		System.err.println("-----"+PackageToDeliver.equals(packageOfClientA));
		//aca el ecuals
		
		
		
		
		
		
		
		
		
		
		
		System.err.println("-------- BEFORE ADDING ORDERS -----------");
		
		
		
		
		
		
		
		
		for (PackageToDeliver item : listOfItems) {
			deliveryJ.getOrderlist().addOrder(item);
		}
//		System.out.println(deliveryJ.getOrderData());
		
		
		deliveryJ.getOrderData();
//		System.out.println(deliveryJ.getOrderlist().toString()); DONT WORK
		
		
		System.err.println("ASDASDKAJSKDASJDKSAJKDJSAKSJKD");
		System.out.println(deliveryJ.toString()); 
		System.err.println("00000000000000000000000000000000000000000000");
		deleteOrder(clientA, deliveryJ);
		deliveryJ.getOrderData();


		
	}
	
/*
 * 
 * 
 * 
 * 					Methods
 * 
 * 
 * 
 * 
 * */
	public void addOrder(Client client, DeliveryPerson delivery, PackageToDeliver item) {
		/* checks if the item isn't already one the order*/
		delivery.getOrderlist().addOrder(item);
		
		System.out.println("Delivery "+delivery.getFirstName()+" is on his way to delivery" + item.getItemName() + " to " + client.getLocation());
		delivery.setState("delivering");
		delivery.setWallet(makedelivery.calculatePrice(item));
		
		
	}
	
	public void deleteOrder(Client client, DeliveryPerson delivery) {
		// Creating iterator object
		Iterator<com.delivery.PackageToDeliver> itr = delivery.getOrderlist().getPackageList().iterator();
		while(itr.hasNext()) {
				
			//remove element if client phone == packageToDeliver phone
			PackageToDeliver x = (PackageToDeliver)itr.next();
			if (x.getClientPhone() == client.getPhone()) {
				itr.remove();
			}
			
		}
	}
	
	public void startDeliver() {
		
	}
	
	public void iteratorOfOrders(DeliveryPerson deli){
		Orders orders = deli.getOrderlist();
		PackageToDeliver[] arr = new PackageToDeliver[orders.length()];
		arr = orders.toArray();
		for (PackageToDeliver packageToDeliver : arr) {
			
			
		}
	}
	
	public void changeWallets(DeliveryPerson p, Client c, float price) {
		
		clientA.setWallet(clientA.getWallet() - price);
		deliveryJ.setWallet(deliveryJ.getWallet() + price);
		System.out.println("Delivery " + deliveryJ.getFirstName() + " got paid " + price + " pesos");
	}

}
