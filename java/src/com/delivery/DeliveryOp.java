package com.delivery;
import com.delivery.persons.*;
import com.delivery.world.Time;
public class DeliveryOp extends Main {
	Time currentTime = new Time(800);
	
	PackageToDeliver PackageToDeliver = new PackageToDeliver("Shoes", 1,4123123);
	PackageToDeliver packageOfClientA = new PackageToDeliver("Shoes", 1,4123123);
	Client clientA = new Client("Client1","Black",4123123,1000, packageOfClientA, "idle", 0, "rosario");
	
	Orders orderlist = new Orders();
	DeliveryPerson deliveryJ = new DeliveryPerson("John", "Doe", 12345, 500,"idle", "12 Street", "30 Street", orderlist, 01);
	
	
	public DeliveryOp() {
		
	
		
//	String item, String state, int deliverId, String location)
	}
	
	public void oneDeliver() {
		System.out.println("START--- The delivery is now at " + deliveryJ.getLocationOrigin());
		int price = 500;
		
		deliveryJ.getOrderlist().addOrder(packageOfClientA);
		currentTime.whatTime();
		
		
		System.out.println(deliveryJ.getOrderData());
//		deliveryJ.getOrderlist().access(0);
		
		if ( deliveryJ.getLocationOrigin().compareTo(deliveryJ.getLocationDestination()) != 0) {
			
			
			currentTime.setHoursminute(60);
			deliveryJ.setLocationOrigin(deliveryJ.getLocationDestination());
			clientA.setWallet(clientA.getWallet()-price);
			deliveryJ.setWallet(deliveryJ.getWallet()+price);
			System.out.println("Delivery "+ deliveryJ.getFirstName() + " got paid "+ price +" pesos");
			//TODO method that calculates the price with the weight of the order
			System.out.println("The delivery is now at " + deliveryJ.getLocationOrigin());
			
			currentTime.whatTime();
			
			//Todo currently each delivery takes 1 hour
		} else {
			System.out.println("The delivery is there");
			
			
		}
	}
	
	

	
	}


