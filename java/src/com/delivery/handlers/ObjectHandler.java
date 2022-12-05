package com.delivery.handlers;

import java.util.Scanner;

import com.delivery.PackageToDeliver;
import com.delivery.persons.Client;

public class ObjectHandler {

	public ObjectHandler() {
		// TODO Auto-generated constructor stub
	}

	public Client customClient() {
		// (String firstName, String lastName, long phone, float wallet,
		// PackageToDeliver packageToDeliver,
//		String state, int deliverId, String location)

		Client c = new Client();
		Scanner record = new Scanner(System.in);
		System.out.println("First name: ");
		String firstName = record.nextLine();
		System.out.println("Last Name");
		String lastName = record.nextLine();
		System.out.println("Phone number:");
		long phone = record.nextLong();
		System.out.println("Money available: ");
		float wallet = record.nextFloat();
		record.nextLine();
		System.out.println("Location");
		String location = record.nextLine();
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setPhone(phone);
		c.setWallet(wallet);
		c.setLocation(location);
		return c;
	}

	public PackageToDeliver customItem(Client client) {
		// String itemName, double weight, long clientPhone, int quantity, String
		// destination
		PackageToDeliver i = new PackageToDeliver();
		Scanner s = new Scanner(System.in);
		System.out.println("Item name: ");
		String itemName = s.nextLine();
		System.out.println("Add weight:");
		double wight = s.nextDouble();
//		System.out.println("Add phone:");
//		long phone = s.nextLong();
		long phone = client.getPhone();
		System.out.println("Add quantity");
		int quantity = s.nextInt();
		System.out.println("Indicate distance in meters");
		int distance = s.nextInt();
		s.nextLine();
		System.out.println("Add destination");
		String destination = s.nextLine();

		i.setItemName(itemName);
		i.setWeight(wight);
		i.setClientPhone(phone);
		i.setWeight(wight);
		i.setDestination(destination);
		i.setDistanceInMeters(distance);
		return i;
	}

}
