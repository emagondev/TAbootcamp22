package com.delivery;

import java.util.ArrayList;
import java.util.Scanner;

import com.delivery.handlers.ObjectCreator;
import com.delivery.persons.Client;
import com.delivery.persons.DeliveryPerson;
import com.delivery.world.Car;
import com.delivery.world.ElectricScooter;
import com.delivery.world.Vehicle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectCreator objectCreator = new ObjectCreator();
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter username");
//	    String userName = myObj.nextLine();
		ArrayList<DeliveryPerson> listOfDeliveries = new ArrayList<>();

		// initialize
		// items
		PackageToDeliver packageOfClientA = new PackageToDeliver("Shoes", 1, 4123123, 1, "Street 70", 2000);
		PackageToDeliver shoes = new PackageToDeliver("Shoes", 1, 4123123, 1, "Street 50", 2000);
		PackageToDeliver flour = new PackageToDeliver("Flour", 1, 4123123, 1, "Street 70", 2000);
		PackageToDeliver trash = new PackageToDeliver("Bag of clothes", 2, 4123123, 1, "Street 70", 2000);

		// clients
		Client clientA = new Client("Client1", "Black", 4123123, 1000, packageOfClientA, "idle", 0, "rosario");
		Client clientCustom = new Client();

//		System.out.println(clientCustom.toString());
//		clientCustom.customizeClient();
		System.out.println(clientCustom.toString());
		System.out.println("0000000000000000000000000000000000");
		// vehicles
		Vehicle carDeliA = new Car("Chevy", 0, 80, 120);
		Vehicle carTest = new ElectricScooter("XiaomiTest", 0, 20, 50);
//		Vehicle bicycle = new ;

		// delivries
		DeliveryPerson deliveryJ = new DeliveryPerson("John", "Doe", 12345, 500, "idle", "12 Street", "30 Street", 1,
				carDeliA);
		DeliveryPerson deliveryTest = new DeliveryPerson("TestName", "TestLName", 8000000, 1, "Idle", "Street 0", null,
				0, carTest);
		listOfDeliveries.add(deliveryJ);
		listOfDeliveries.add(deliveryTest);
		deliveryJ.removePackage(trash);

		System.out.println(listOfDeliveries.toString());
		System.out.println("9999999999999999999999999999");
		
		//creation of custom client
		Client custom1 = objectCreator.customClient();
		System.out.println(custom1.toString());
		

		// execution
		DeliveryService delivery = new DeliveryService();
//		delivery.deliverAPackage(shoes, deliveryJ, clientA);

	}

}
