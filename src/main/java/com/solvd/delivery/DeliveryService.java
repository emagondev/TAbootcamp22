package com.solvd.delivery;

import com.solvd.delivery.handlers.Order;
import com.solvd.delivery.enums.OrderStatus;
import com.solvd.delivery.handlers.ObjectCreator;
import com.solvd.delivery.persons.Client;
import com.solvd.delivery.persons.DeliveryPerson;
import com.solvd.delivery.world.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

import static com.solvd.delivery.enums.DeliveryTier.*;


public class DeliveryService {
    private static final Logger LOGGER = LogManager.getLogger(DeliveryService.class);
    ObjectCreator objectCreator = new ObjectCreator();
    Order orderStatus = new Order();
    LinkedList<Client> listOfClients = new LinkedList<>();
    LinkedList<DeliveryPerson> listOfDeliveries = new LinkedList<>();
    LinkedList<Order> orderRecord = new LinkedList<>();

    public DeliveryService() {
    }

    public void deliveryTest(DeliveryPerson delivery) {
        Location address1 = new Location(3500, 400);
        Location address2 = new Location(400, 124);
        Location address3 = new Location(1740, 1000);

        PackageToDeliver[] listOfItems = {
                new PackageToDeliver("Item1", 1, "100000", 1, address1),
                new PackageToDeliver("Item2", 1, "100000", 1, address1),
                new PackageToDeliver("Item3", 2, "100000", 1, address2)};
        for (PackageToDeliver item : listOfItems) {
            delivery.addPackage(item);
        }
    }

    public void addDelivery(DeliveryPerson d) {
        listOfDeliveries.add(d);
    }

    public void deliveryHandler(Order order, Client client) {
//        listOfDeliveries
       
//      gives those items to a DeliveryPerson
        order.setStatus(OrderStatus.READY);
        order.getDeliveryPerson().setLocation(client.getLocation());
//        delivery.setLocation(client.getLocation());
        LOGGER.info("Client location" + (client.getLocation().toString()));
        LOGGER.info("Delivery location" + (order.getDeliveryPerson().getLocation().toString()));
        //calculate the price with the location of the first item in the list
        changeWallets(
                order.getDeliveryPerson(),
                order.getClient(),
                order.getDeliveryPerson().calculatePrice(distanceCalculator(order.getDeliveryPerson(),
                        order.getDeliveryPerson().getItemList().get(0)), order.getTier())
        );

        //use lambda to delete all the packages in the DeliveryPerson list with the same phone as the client

        order.getDeliveryPerson().getItemList().removeIf(p -> p.getClientPhone().compareTo(client.getPhone()) == 0);
        order.setStatus(OrderStatus.DELIVERED);
        LOGGER.info("The delivery was completed");

    }

    public Order clientHandler(Client user, Order order) {

        //FIX SACAR ORDER AFUERA, hacer que lo devuelva

        // Modifies the user, adds the item to be delivered to a list and adds the list to the selected delivery

        Scanner scan = new Scanner(System.in);
        LinkedList<PackageToDeliver> clientOrder = new LinkedList<>();
        char option = ' ';
        int compare;
        System.out.println("Please register");
        objectCreator.modifyClient(user);
        compare = Character.compare(option, '7');
//            if (Character.compare(option, '1') == 0) {
        LOGGER.info("Choose a destination");
        Location destination = objectCreator.recordCoordinates("Choose destination (coordinates)");
        System.out.println("Add item");
        char c = 'y';
        while (Character.compare(c, 'y') == 0) {
            clientOrder.add(objectCreator.customItem(user, destination));
            System.out.println("Add another one? (y/n)");
            c = scan.nextLine().charAt(0);
        }
        System.out.println("You are going to deliver:");
        for (PackageToDeliver p : clientOrder) {
            LOGGER.info(p.getItemName());
        }
        System.out.println("Choose a delivery speed tier: A.slow B.medium C.fast");
        int tier = 0;
        String tierLetter = String.valueOf(scan.nextLine().charAt(0)).toLowerCase();
        switch (tierLetter) {
            case "a":
                tier = 40;
                break;
            case "b":
                tier = 70;
                break;
            case "c":
                tier = 120;
                break;
            default:
                throw new RuntimeException("Tier is not suported--- " + tierLetter);

        }

        //fix Agregar excepcion cuando tier no esta en el rango
        //gets the desired delivery person,
//        List<DeliveryPerson> list = bringDeliveryP(listOfDeliveries, tier);

        if (tier >= HIGH.value && tier <= MAXVALUE.value) {
            //implement streams and lambda function
            order.setDeliveryPerson(listOfDeliveries.stream()
                    .filter(d -> d.getVehicle().getMaxSpeed() >= HIGH.value).collect(Collectors.toList()).get(0));
            order.getDeliveryPerson().addListOfPackages(clientOrder);
            order.setTier(3);

        } else if (tier > LOW.value && tier < HIGH.value) {
            //implement streams and lambda function
            order.setDeliveryPerson(listOfDeliveries.stream()
                    .filter(d -> (d.getVehicle().getMaxSpeed() < HIGH.value && d.getVehicle().getMaxSpeed() > LOW.value))
                    .collect(Collectors.toList()).get(0));
            order.getDeliveryPerson().addListOfPackages(clientOrder);
            order.setTier(2);
        } else if (tier >= MINVALUE.value && tier <= LOW.value) {
            //implement streams and lambda function
//            listOfDeliveries.stream()
//                    .filter(d -> d.getVehicle().getMaxSpeed() <= LOW.value)
//                    .collect(Collectors.toList()).get(0).addListOfPackages(clientOrder);
            order.setDeliveryPerson(listOfDeliveries.stream()
                    .filter(d -> d.getVehicle().getMaxSpeed() <= LOW.value)
                    .collect(Collectors.toList()).get(0));
            order.getDeliveryPerson().addListOfPackages(clientOrder);
            order.setTier(1);
        }


        //FIX------------ Se comento las 5 lineas inmediatamente debajo
//        bringDeliveryP(tier).get(0).addListOfPackages(clientOrder);
        //tambien se elimina la linea 127 (ahora comentada)
//        adds all the items the client ordered
//        list.get(0).addListOfPackages(clientOrder);
//        System.err.println(whoIsMyDelivery(listOfDeliveries, user));
        order.setClient(user);
        orderStatus.setStatus(OrderStatus.ORDERED);
        System.out.println(
                order.getDeliveryPerson().toString());
        return order;

    }

    public void addOrder(Order order) {
        orderRecord.add(order);
    }


    public List<DeliveryPerson> bringDeliveryP(int chosenTier) {
        //given a chosen tier it returns a delivery person of that tier
        LinkedList<DeliveryPerson> listOfDeliveriesRequested = new LinkedList<>();
//        List<DeliveryPerson> listOfDeliveriesRequested2 = new ArrayList<>();

        //this block filters the deliveries which of that tier in a list
        if (isBetween(chosenTier, HIGH.value, MAXVALUE.value)) {
            //implement streams and lambda function
            listOfDeliveriesRequested.addAll(listOfDeliveries.stream()
                    .filter(d -> d.getVehicle().getMaxSpeed() > HIGH.value)
                    .collect(Collectors.toList()));
        } else if (isBetween(chosenTier, LOW.value, HIGH.value)) {
            //implement streams and lambda function
            listOfDeliveriesRequested.addAll(listOfDeliveries.stream()
                    .filter(d -> (d.getVehicle().getMaxSpeed() < HIGH.value && d.getVehicle().getMaxSpeed() > LOW.value))
                    .collect(Collectors.toList()));
        } else if (isBetween(chosenTier, MINVALUE.value, LOW.value)) {
            //implement streams and lambda function
            listOfDeliveriesRequested.addAll(listOfDeliveries.stream()
                    .filter(d -> d.getVehicle().getMaxSpeed() <= LOW.value)
                    .collect(Collectors.toList()));

        }

        return listOfDeliveriesRequested;

    }

    //    public int bringDeliverySelectedTier()
    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x < upper;
    }

    public double distanceCalculator(DeliveryPerson delivery, PackageToDeliver item) {
        double amount;
        double distanceInMeters;
//      Math.sqrt(Math.pow(l.getX() - x, 2) + Math.pow(l.getY() - y, 2));
        distanceInMeters = Math.sqrt(Math.pow(
                delivery.getLocation().getCoordinateX() - item.getDestinationX(), 2) +
                Math.pow(
                        delivery.getLocation().getCoordinateY() - item.getDestinationY(), 2
                ));
        return distanceInMeters;
    }

    public void changeWallets(DeliveryPerson d, Client c, float price) {
        c.setWallet(c.getWallet() - price);
        d.setWallet(d.getWallet() + price);
        LOGGER.info("Delivery " + d.getFirstName() + " got paid " + price + " pesos by " + c.getFirstName());
        LOGGER.info("Now he has: " + d.getWallet());

    }

    public DeliveryPerson whoIsMyDelivery(LinkedList<DeliveryPerson> list, Client client) {
        //filters the delivery who has a package with the phone of the client
        ArrayList<DeliveryPerson> myDeliveryList = new ArrayList<>();
        try {
            DeliveryPerson myDelivery =
                    list.stream().filter(deliveryPerson -> deliveryPerson.getItemList().get(0).getClientPhone().compareTo(client.getPhone()) == 0).collect(Collectors.toList()).get(0);

            myDeliveryList.add(myDelivery);
        } catch (Exception e) {
            LOGGER.info("Something went wrong at whoIsMyDelivery");
        }

        return myDeliveryList.get(0);
    }

}
