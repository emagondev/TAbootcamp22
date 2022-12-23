package com.solvd.delivery;

//imports


import com.solvd.delivery.enums.Order;
import com.solvd.delivery.enums.OrderStatus;
import com.solvd.delivery.world.Location;
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
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        Order order = new Order();
        Client user = new Client();
        // initialize---------------------
//       adresses
        Location address1 = new Location(3500, 400);
        Location address2 = new Location(400, 124);
        Location address0 = new Location(0, 0);
        // vehicles---------------------
        Car vehicleTierIII = new Car("Ford", 0, 120, 100);
        ElectricScooter vehicleTierII = new ElectricScooter("XiaomiTest", 0, 80, 50);
        Vehicle vehicleTierI = new Vehicle("BTM", 0, 40);
        // deliveries----------------

        DeliveryPerson deliveryA = new DeliveryPerson("John", "Doe", "12345", 500, address0, address0, "idle", 0,
                vehicleTierIII);
        DeliveryPerson deliveryB = new DeliveryPerson("William", "Jones", "482156", 200, address0, address0, "idle", 0,
                vehicleTierII);
        DeliveryPerson deliveryC = new DeliveryPerson("Peter", "Parker", "482156", 200, address0, address0, "idle", 0
                , vehicleTierI);

        DeliveryPerson a = new DeliveryPerson();
//        adding deliveries to list
        deliveryService.addDelivery(deliveryA);
        deliveryService.addDelivery(deliveryB);
        deliveryService.addDelivery(deliveryC);

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

        deliveryService.clientHandler(user);
//        deliveryService.deliveryHandler(listOfDeliveries, order, user);

    }
}