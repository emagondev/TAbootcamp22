package com.solvd.delivery;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import java.util.logging.Logger;

import java.util.ArrayList;


import com.solvd.delivery.handlers.ObjectCreator;
import com.solvd.delivery.persons.Client;
import com.solvd.delivery.persons.DeliveryPerson;
import com.solvd.delivery.world.Car;
import com.solvd.delivery.world.ElectricScooter;
import com.solvd.delivery.world.Vehicle;

public class Main {
//    private static final Logger loggerObj=Logger.getLogger(Main.class.getName());
    static Logger loggerObj= LogManager.getLogger("Main");
    public static void main(String[] args) {

        System.out.println("Hello world!");
        loggerObj.debug("Printing toLogger");


        // TODO Auto-generated method stub
        ObjectCreator objectCreator = new ObjectCreator();
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

        // deliveries
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