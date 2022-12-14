package com.solvd.delivery.handlers;

import java.util.LinkedList;
import java.util.Scanner;

import com.solvd.delivery.PackageToDeliver;
import com.solvd.delivery.persons.Client;
import com.solvd.delivery.persons.DeliveryPerson;
import com.solvd.delivery.world.Location;

public class ObjectCreator {


    public ObjectCreator() {
        // TODO Auto-generated constructor stub
    }

    public Client customClient() {
        Client c = new Client();
        Scanner record = new Scanner(System.in);
        try {
            System.out.println("First name: ");
            String firstName = record.nextLine();
            System.out.println("Last Name");
            String lastName = record.nextLine();
            System.out.println("Phone number:");
            String phone = record.nextLine();
            System.out.println("Money available: ");
            float wallet = record.nextFloat();
            record.nextLine();
            Location location = recordCoordinates("Input your location (coordinates)");


            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setPhone(phone);
            c.setWallet(wallet);
            c.setLocation(location);
//			return c;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("One or more parameters were incorrect");
        }
        return c;

    }

    public void modifyClient(Client c) {
//		String state, int deliverId, String location)

        Scanner record = new Scanner(System.in);
        try {
            System.out.println("First name: ");
            String firstName = record.nextLine();
            System.out.println("Last Name");
            String lastName = record.nextLine();
            System.out.println("Phone number:");
            String phone = record.nextLine();
            System.out.println("Money available: ");
            float wallet = record.nextFloat();
            record.nextLine();
            Location location = recordCoordinates("Input your location (coordinates)");

            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setPhone(phone);
            c.setWallet(wallet);
            c.setLocation(location);
//			return c;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("One or more parameters were incorrect");
        }

    }

    public DeliveryPerson customDeliveryPerson() {

        DeliveryPerson d = new DeliveryPerson();
        Scanner s = new Scanner(System.in);

        try {
            System.out.println("Creating delivery person");
            System.out.println("First name: ");
            String firstName = s.nextLine();
            System.out.println("Last Name");
            String lastName = s.nextLine();
            System.out.println("Phone number:");
            String phone = s.nextLine();
            System.out.println("Money available: ");
            float wallet = s.nextFloat();
            s.nextLine();
            Location location = recordCoordinates("Choose current location (coordinates)");
            d.setFirstName(firstName);
            d.setLastName(lastName);
            d.setPhone(phone);
            d.setWallet(wallet);
            d.setLocation(location);

        } catch (Exception e) {
            System.err.println("One or more parameters were incorrect");
        }
        return d;
    }

    public PackageToDeliver customItem(Client client, Location destination) {
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
            String phone = client.getPhone();
            System.out.println("Add quantity");
            int quantity = s.nextInt();
//            double[] doubleArray = recordCoordinates("Choose destination (coordinates)");
            i.setItemName(itemName);
            i.setWeight(wight);
            i.setClientPhone(phone);
            i.setQuantity(quantity);
            i.setWeight(wight);
            i.setDestination(destination);
        } catch (Exception e) {
            System.err.println("One or more parameters were incorrect");
        }
        return i;
    }

    public void addClient(LinkedList<Client> list) {
        list.add(customClient());
    }

    public Location recordCoordinates(String text) {
        Scanner s = new Scanner(System.in);
//        System.out.println("Choose current location (coordinates)");
        System.out.println(text);
        System.out.println("Coordinate X");
        double locationX = s.nextDouble();
        System.out.println("Coordinate Y");
        double locationY = s.nextDouble();
        Location location = new Location();
        location.setCoordinateX(locationX);
        location.setCoordinateY(locationY);
        return location;
    }


}
