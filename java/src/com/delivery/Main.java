package com.delivery;
import java.util.Scanner;
import com.delivery.persons.Client;
import com.delivery.persons.DeliveryPerson;
import com.delivery.world.Car;
import com.delivery.world.ElectricScooter;
import com.delivery.world.Vehicle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter username");
//	    String userName = myObj.nextLine();
	    
	    
		//initialize
		//items
		PackageToDeliver PackageToDeliver = new PackageToDeliver("Shoes", 1, 4123123, 1, "Street 70");
		PackageToDeliver packageOfClientA = new PackageToDeliver("Shoes", 1, 4123123, 1, "Street 70");
		PackageToDeliver shoes = new PackageToDeliver("Shoes", 1, 4123123, 1, "Street 50");
		PackageToDeliver flour = new PackageToDeliver("Flour", 1, 4123123, 1, "Street 70");
		PackageToDeliver trash = new PackageToDeliver("Bag of clothes", 2, 4123123, 1, "Street 70");

		//clients
		Client clientA = new Client("Client1", "Black", 4123123, 1000, packageOfClientA, "idle", 0, "rosario");
		Client clientCustom = new Client();
		System.out.println(clientCustom.toString());
		clientCustom.customizeClient();
		System.out.println(clientCustom.toString());
		
		
		//vehicles
		Vehicle carDeliA = new Car("Chevy", 0, 80, 120);
		Vehicle carTest = new ElectricScooter("XiaomiTest", 0, 20, 50);
//		Vehicle bicycle = new ;
		
		//delivries
		DeliveryPerson deliveryJ = new DeliveryPerson("John", "Doe", 12345, 500, "idle", "12 Street", "30 Street",
				 1, carDeliA);
		DeliveryPerson deliveryTest = new DeliveryPerson("TestName", "TestLName", 8000000, 1, "Idle", "Street 0", null,
				 0, null);

	
		
		DeliveryService delivery = new DeliveryService();
		//execution
//		delivery.deliverAPackage(shoes, deliveryJ, clientA);
		
		
	}

}
