package com.solvd.delivery.handlers;

import java.util.LinkedList;
import java.util.Scanner;

import com.solvd.delivery.PackageToDeliver;
import com.solvd.delivery.persons.Client;
import com.solvd.delivery.persons.DeliveryPerson;

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
            double[] doubleArray = recordCoordinates("Imput your location (coordinates)");


            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setPhone(phone);
            c.setWallet(wallet);
            c.setLocation(doubleArray);
//			return c;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("One or more parameters were incorect");
        }
        return c;

    }

    public void modifyClient(Client c) {
        // (String firstName, String lastName, long phone, float wallet,
        // PackageToDeliver packageToDeliver,
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
            double[] doubleArray = recordCoordinates("Imput your location (coordinates)");

            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setPhone(phone);
            c.setWallet(wallet);
            c.setLocation(doubleArray);
//			return c;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("One or more parameters were incorect");
        }

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
            String phone = s.nextLine();
            System.out.println("Money available: ");
            float wallet = s.nextFloat();
            s.nextLine();
            double[] doubleArray = recordCoordinates("Choose current location (coordinates)");
            d.setFirstName(firstName);
            d.setLastName(lastName);
            d.setPhone(phone);
            d.setWallet(wallet);
            d.setLocationCurrent(doubleArray);

        } catch (Exception e) {
            System.err.println("One or more parameters were incorect");
        }
        return d;
    }

    public PackageToDeliver customItem(Client client, double[] destination) {
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
            System.err.println("One or more parameters were incorect");
        }
        return i;
    }

    public void addClient(LinkedList<Client> list) {
        list.add(customClient());
    }

    public double[] recordCoordinates(String text) {
        Scanner s = new Scanner(System.in);
//        System.out.println("Choose current location (coordinates)");
        System.out.println(text);
        System.out.println("Coordinate X");
        double locationX = s.nextDouble();
        System.out.println("Coordinate Y");
        double locationY = s.nextDouble();
        double[] doubleArray;
        doubleArray = new double[]{locationX, locationY};
        return doubleArray;
    }

    ;


}
