package com.solvd.delivery;

//imports


import com.solvd.delivery.handlers.Order;
import com.solvd.delivery.world.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.delivery.persons.Client;
import com.solvd.delivery.persons.DeliveryPerson;
import com.solvd.delivery.world.Car;
import com.solvd.delivery.world.ElectricScooter;
import com.solvd.delivery.world.Vehicle;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        Order order = new Order();
        Client user = new Client();
        // initialize---------------------
//       addresses
        Location address1 = new Location(3500, 400);
        Location address0 = new Location(0, 0);
        // vehicles---------------------
        Car vehicleTierIII = new Car("Ford", 0, 120, 100);
        ElectricScooter vehicleTierII = new ElectricScooter("XiaomiTest", 0, 80, 50);
        Vehicle vehicleTierI = new Vehicle("BTM", 0, 40);
        // deliveries----------------
        deliveryService.addDelivery(new DeliveryPerson("John", "Doe", "12345", 500, address0, address0, "idle", 0, vehicleTierIII));
        deliveryService.addDelivery(new DeliveryPerson("William", "Jones", "482156", 200, address0, address0, "idle", 0, vehicleTierII));
        deliveryService.addDelivery(new DeliveryPerson("Peter", "Parker", "482156", 200, address0, address0, "idle", 0, vehicleTierI));

        // items (not used)
        PackageToDeliver packageOfClientA = new PackageToDeliver("Shoes", 1, "4123123", 1, address1);
        PackageToDeliver shoes = new PackageToDeliver("Shoes", 1, "4123123", 1, address1);
        PackageToDeliver flour = new PackageToDeliver("Flour", 1, "4123123", 1, address1);
        PackageToDeliver trash = new PackageToDeliver("Bag of clothes", 2, "4123123", 1, address1);


        deliveryService.clientHandler(user, order);
        deliveryService.deliveryHandler(order, user);

    }
}