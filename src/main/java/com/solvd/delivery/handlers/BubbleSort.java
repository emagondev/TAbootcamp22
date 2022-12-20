package com.solvd.delivery.handlers;

import com.solvd.delivery.persons.DeliveryPerson;

import java.util.*;

public class BubbleSort {
    // Java program for implementation of Bubble Sort


//    void bubbleSort(LinkedList<DeliveryPerson> list) {
//        int n = list.size();
//        for (int i = 0; i < n - 1; i++)
//            for (int j = 0; j < n - i - 1; j++)
//                if (list.get(j).getVehicle().getMaxSpeed() > list.get(j + 1).getVehicle().getMaxSpeed()) {
//                    // swap arr[j+1] and arr[j]
//                    DeliveryPerson temp = list.get(j);
//                    list.add(j,list.get(j + 1)) ;
//                    list.[j + 1] = temp;
//                }
//    }

    /* Prints the array */
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to test above
//    public static void main(String args[]) {
//        BubbleSort ob = new BubbleSort();
//        int arr[] = {5, 1, 4, 2, 8};
//        ob.bubbleSort(arr);
//        System.out.println("Sorted array");
//        ob.printArray(arr);
//    }


}
