package com.delivery.handlers;

import java.util.Scanner;

import com.delivery.persons.Client;

public class Menu {

	private String state = "notLogged"; // or logged

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public char recordOption() {
		Scanner myObj = new Scanner(System.in);
		char option = myObj.nextLine().charAt(0);
		return option;
	}

	public void options() {
		System.out.println("Choose an option");
		System.out.println("A. Register client");
		System.out.println("B. Add item");
		System.out.println("C. Choose delivery tier");
	}

	public Client createClient() {
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

		return c;
	}

	public void customItem() {
		// String itemName, double weight, long clientPhone, int quantity, String
		// destination
		Scanner s = new Scanner(System.in);
		System.out.println("Item name: ");
		String itemName = s.nextLine();
		System.out.println("Add weight:");
		double wight = s.nextDouble();
		System.out.println("Add phone:");
		long phone = s.nextLong();
		System.out.println("Add quantity");
		int quantity = s.nextInt();
		s.nextLine();
		System.out.println("Add destination");
		String destination = s.nextLine();
	}
}
