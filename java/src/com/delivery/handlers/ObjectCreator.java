package com.delivery.handlers;

import java.util.Scanner;

import com.delivery.PackageToDeliver;
import com.delivery.persons.Client;
import com.delivery.persons.DeliveryPerson;

public class ObjectCreator {

	public ObjectCreator() {
		// TODO Auto-generated constructor stub
	}

	public Client customClient() {
		// (String firstName, String lastName, long phone, float wallet,
		// PackageToDeliver packageToDeliver,
//		String state, int deliverId, String location)

		Client c = new Client();
		Scanner record = new Scanner(System.in);
		try {
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
//			return c;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("One or more parameters were incorect");
		}
		return c;

	}

	public DeliveryPerson customDeliveryPerson() {
		/*
		 * String firstName, String lastName, long phone, long wallet, String state,
		 * String locationOrigin, String locationDestination, int deliverId, Vehicle
		 * vehicle
		 */
		DeliveryPerson d = new DeliveryPerson();
		Scanner s = new Scanner(System.in);

		try {
			System.out.println("Creating delivery person");
			System.out.println("First name: ");
			String firstName = s.nextLine();
			System.out.println("Last Name");
			String lastName = s.nextLine();
			System.out.println("Phone number:");
			long phone = s.nextLong();
			System.out.println("Money available: ");
			float wallet = s.nextFloat();
			s.nextLine();
			System.out.println("Location Origin: ");
			String location = s.nextLine();
			System.out.println("Location destination");
			String locationD = s.nextLine();

			d.setFirstName(firstName);
			d.setLastName(lastName);
			d.setPhone(phone);
			d.setWallet(wallet);
			d.setLocationOrigin(location);
			d.setLocationDestination(locationD);
		} catch (Exception e) {
			System.err.println("One or more parameters were incorect");
		}
		return d;
	}

	public PackageToDeliver customItem(Client client) {
		// String itemName, double weight, long clientPhone, int quantity, String
		// destination
		PackageToDeliver i = new PackageToDeliver();
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("Creating item");
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
			i.setQuantity(quantity);
			i.setWeight(wight);
			i.setDestination(destination);
			i.setDistanceInMeters(distance);
		} catch (Exception e) {
			System.err.println("One or more parameters were incorect");
		}
		return i;
	}

}
