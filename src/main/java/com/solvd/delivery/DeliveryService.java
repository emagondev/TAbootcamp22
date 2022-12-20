package com.solvd.delivery;

import com.solvd.delivery.enums.Order;
import com.solvd.delivery.enums.OrderStatus;
import com.solvd.delivery.handlers.ObjectCreator;
import com.solvd.delivery.persons.Client;
import com.solvd.delivery.persons.DeliveryPerson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

import static com.solvd.delivery.enums.DeliveryTier.*;


public class DeliveryService {
    private static final Logger logger = LogManager.getLogger(DeliveryService.class);

    public DeliveryService() {
    }

    public void deliveryTest(DeliveryPerson delivery) {
        double[] address1 = {3500, 400};
        double[] address2 = {400, 124};
        double[] address3 = {1741, 1000};
        PackageToDeliver[] listOfItems = {
                new PackageToDeliver("Item1", 1, "100000", 1, address1),
                new PackageToDeliver("Item2", 1, "100000", 1, address1),
                new PackageToDeliver("Item3", 2, "100000", 1, address2)};
        for (PackageToDeliver item : listOfItems) {
            delivery.addPackage(item);
        }

    }


    public void deliveryHandler(LinkedList<DeliveryPerson> deliveryList, Order order, Client client) {
        DeliveryPerson delivery = whoIsMyDelivery(deliveryList, client);
//      gives those items to a DeliveryPerson
        order.setStatus(OrderStatus.READY);
        delivery.setLocationCurrent(client.getLocation());
        logger.info("Client location" + Arrays.toString(client.getLocation()));
        logger.info("Delivery location" + Arrays.toString(delivery.getLocationCurrent()));
        //calculate the price with the location of the first item in the list
        changeWallets(
                delivery,
                client,
                delivery.calculatePrice(distanceCalculator(delivery,
                        delivery.getItemList().get(0)))
        );

        //use lambda to delete all the packages in the DeliveryPerson list with the same phone as the client

        delivery.getItemList().removeIf(p -> p.getClientPhone().compareTo(client.getPhone()) == 0);
        order.setStatus(OrderStatus.DELIVERED);
        logger.info("The delivery was completed");

    }

    public void clientHandler(Client user, LinkedList<DeliveryPerson> listOfDeliveries, Order order) {
        // Modifies the user, adds the item to be delivered to a list
        //
        ObjectCreator objectCreator = new ObjectCreator();
        Scanner scan = new Scanner(System.in);
        LinkedList<PackageToDeliver> clientOrder = new LinkedList<>();
        char option = ' ';
        int compare;
        System.out.println("Please register");
        objectCreator.modifyClient(user);

//        do {
//            System.out.println("Choose an option");
//        System.out.println("Deliver something");
//          System.out.println("2. Get something delivered to me");

//        option = scan.nextLine().charAt(0);
        compare = Character.compare(option, '7');
//            if (Character.compare(option, '1') == 0) {
        logger.info("Choose a destination");
        double[] destination = objectCreator.recordCoordinates("Choose destination (coordinates)");
        System.out.println("Add item");
        char c = 'y';
        while (Character.compare(c, 'y') == 0) {
            clientOrder.add(objectCreator.customItem(user, destination));
            System.out.println("Add another one? (y/n)");
            c = scan.nextLine().charAt(0);
        }
        System.out.println("You are going to deliver:");
        System.out.println(clientOrder.toString());
        System.out.println("Choose a delivery speed tier: slow(40), medium(70), fast(120)");
        int tier = scan.nextInt();

        //gets the desired delivery person, adds all the items the client ordered
        listOfDeliveries.get(listOfDeliveries.indexOf(bringDeliveryP(listOfDeliveries, tier))).addListOfPackages(clientOrder);
//        order.setStatus(Order.OrderStatus.ORDERED);
        order.setStatus(OrderStatus.ORDERED);

//            } else {
//                System.out.println("TO-DO");
//                break;
//            }

//            System.out.println("2. See delivery cart");
//        } while (compare != 0);
    }

    public DeliveryPerson bringDeliveryP(LinkedList<DeliveryPerson> list, int chosenTier) {
        //given a chosen tier it returns a delivery person of that tier
        ArrayList<DeliveryPerson> listOfDeliveriesRequested = new ArrayList<>();

        //this block filters the deliveries which of that tier in a list

        System.err.println(HIGH.value);


        /*
         *
         *
         *
         *
         * */

        if (isBetween(chosenTier, HIGH.value, MAXVALUE.value)) {
            //implement streams and lambda function
            listOfDeliveriesRequested =
                    (ArrayList<DeliveryPerson>) list.stream()
                            .filter(d -> d.getVehicle().getMaxSpeed() > HIGH.value)
                            .collect(Collectors.toList());
        } else if (isBetween(chosenTier, MEDIUM.value, HIGH.value)) {
            //implement streams and lambda function
            listOfDeliveriesRequested =
                    (ArrayList<DeliveryPerson>) list.stream()
                            .filter(d -> (d.getVehicle().getMaxSpeed() < HIGH.value && d.getVehicle().getMaxSpeed() > LOW.value))
                            .collect(Collectors.toList());
        } else if (isBetween(chosenTier, LOW.value, MEDIUM.value)) {
            //implement streams and lambda function
            listOfDeliveriesRequested =
                    (ArrayList<DeliveryPerson>) list.stream()
                            .filter(d -> d.getVehicle().getMaxSpeed() <= LOW.value)
                            .collect(Collectors.toList());


        }




        /*
         *
         *
         *
         * */
        //brings a random delivery person
//        return listOfDeliveriesRequested.get((int) (Math.random() * ((listOfDeliveriesRequested.size()) + 1)));
//        return listOfDeliveriesRequested.get((int) (Math.random() * ((listOfDeliveriesRequested.size()))));
//        DeliveryPerson deli = listOfDeliveriesRequested.
        return listOfDeliveriesRequested.get(0);

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
                delivery.getLocationOriginX() - item.getDestinationX(), 2) +
                Math.pow(
                        delivery.getLocationOriginY() - item.getDestinationY(), 2
                ));
        return distanceInMeters;
    }

    public void changeWallets(DeliveryPerson d, Client c, float price) {
        c.setWallet(c.getWallet() - price);
        d.setWallet(d.getWallet() + price);
        logger.info("Delivery " + d.getFirstName() + " got paid " + price + " pesos by " + c.getFirstName());
        logger.info("Now he has: " + d.getWallet());

    }

    public DeliveryPerson whoIsMyDelivery(LinkedList<DeliveryPerson> list, Client client) {
        //filters the delivery who has a package with the phone of the client
        ArrayList<DeliveryPerson> myDeliveryList = new ArrayList<>();
        try {
            DeliveryPerson myDelivery =
                    list.stream().filter(deliveryPerson -> deliveryPerson.getItemList().get(0).getClientPhone().compareTo(client.getPhone()) == 0).collect(Collectors.toList()).get(0);

            myDeliveryList.add(myDelivery);
        } catch (Exception e) {
            logger.info("Something went wrong at whoIsMyDelivery");
        }

        return myDeliveryList.get(0);
    }

}
