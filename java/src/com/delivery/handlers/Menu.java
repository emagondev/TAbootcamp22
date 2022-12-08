package com.delivery.handlers;

import java.util.Scanner;

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
		Scanner s = new Scanner(System.in);
		char option =' ';
		System.out.println("Choose an option");
		System.out.println("A. Register client");
		option = s.nextLine().charAt(0);
		System.out.println("B. Add item");
		System.out.println("C. Choose delivery tier");
	}

}
