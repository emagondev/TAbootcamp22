package com.solvd.delivery;

//imports


import com.solvd.delivery.enums.Order;
import com.solvd.delivery.enums.OrderStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;

import com.solvd.delivery.handlers.ObjectCreator;
import com.solvd.delivery.PackageToDeliver;
import com.solvd.delivery.persons.Client;
import com.solvd.delivery.persons.DeliveryPerson;
import com.solvd.delivery.world.Car;
import com.solvd.delivery.world.ElectricScooter;
import com.solvd.delivery.world.Vehicle;
import org.apache.logging.log4j.util.SystemPropertiesPropertySource;

public class Main {
    //    private static final Logger loggerObj=Logger.getLogger(Main.class.getName());
    static Logger loggerObj = LogManager.getLogger("Main");

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        LinkedList<Client> listOfClients = new LinkedList<>();
        LinkedList<DeliveryPerson> listOfDeliveries = new LinkedList<>();
        Order order = new Order();
        Client user = new Client();
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        ObjectCreator objectCreator = new ObjectCreator();

        // initialize---------------------
//       adresses
        double[] address1 = {3500, 400};
        double[] address2 = {400, 124};
        // vehicles---------------------
        Car vehicleTierIII = new Car("Ford", 0, 120, 100);
        ElectricScooter vehicleTierII = new ElectricScooter("XiaomiTest", 0, 80, 50);
        Vehicle vehicleTierI = new Vehicle("BTM", 0, 40);
        // deliveries----------------
        double[] address0;
        address0 = new double[]{0, 0};
        DeliveryPerson deliveryA = new DeliveryPerson("John", "Doe", "12345", 500, "idle", address0, null, 0, vehicleTierIII);
        DeliveryPerson deliveryB = new DeliveryPerson("William", "Jones", "482156", 200, "idle", address0, null, 0, vehicleTierII);
        DeliveryPerson deliveryC = new DeliveryPerson("Peter", "Parker", "482156", 200, "idle", address0, null, 0, vehicleTierI);

//        adding deliveries to list
        listOfDeliveries.add(deliveryA);
        listOfDeliveries.add(deliveryB);
        listOfDeliveries.add(deliveryC);

        // items (not used)
        PackageToDeliver packageOfClientA = new PackageToDeliver("Shoes", 1, "4123123", 1, address1);
        PackageToDeliver shoes = new PackageToDeliver("Shoes", 1, "4123123", 1, address1);
        PackageToDeliver flour = new PackageToDeliver("Flour", 1, "4123123", 1, address1);
        PackageToDeliver trash = new PackageToDeliver("Bag of clothes", 2, "4123123", 1, address1);

        // clients
//        Client clientA = new Client("Client1", "Black", 4123123, 1000, packageOfClientA, "idle", 0, "rosario");
//        listOfClients.add(clientA);
//        Client clientCustom = new Client();
//        listOfClients.add(clientCustom);
//        loggerObj.debug(listOfClients.toString());

        deliveryService.clientHandler(user, listOfDeliveries, order);
        deliveryService.deliveryHandler(listOfDeliveries, order, user);

    }
}