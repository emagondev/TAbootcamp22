/**
 * 
 */
package com;

/**
 * @author em4go
 *
 */
public class SortingAlg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line = args[0];
		String[] numberStrs = line.split(",");
		int[] numbers = new int[numberStrs.length];
		for(int i = 0;i < numberStrs.length;i++)
		{
		   // Note that this is assuming valid input
		   // If you want to check then add a try/catch 
		   // and another index for the numbers if to continue adding the others (see below)
		   numbers[i] = Integer.parseInt(numberStrs[i]);
		}
		mergeSort(numbers);
		printArr(numbers);
		
	}
	
	private static void mergeSort(int[] array){
		int arrLength = array.length;
		
		if (arrLength <2) {
			return;
		}
		
		int halfLength = arrLength/2;
		int[] arr1 = new int[halfLength];
		int arr2[] = new int[arrLength - halfLength];
		
		for (int i=0; i < halfLength; i++) {
			arr1[i] = array[i];
		}
			
		for (int i= halfLength; i < arrLength; i++) {
				arr2[i - halfLength] = array[i];
		}
		
		mergeSort(arr1);
		mergeSort(arr2);
		
		merge(array,arr1,arr2);
	}
	
	
	private static void merge(int[] originalArray, int[] arr1, int[] arr2) {
		int arr1length = arr1.length;
		int arr2length = arr2.length;
		int i1=0,i2=0, oArrayIndex = 0;
		
		while (i1 < arr1length && i2 < arr2length) {
			if (arr1[i1] <= arr2[i2]) {
				originalArray[oArrayIndex] = arr1[i1];
				i1++;
			}
			else {
				originalArray[oArrayIndex] = arr2[i2];
				i2++;
			}
			oArrayIndex++;
		}
		
		while (i1 < arr1length) {
			originalArray[oArrayIndex] = arr1[i1];
			i1++;
			oArrayIndex++;
		}
		while (i2 < arr2length) {
			originalArray[oArrayIndex] = arr2[i2];
			i2++;
			oArrayIndex++;
		}
			
	}

	private static void printArr(int[] numbers) {
		System.out.print("[ ");
		for (int i =0; i<numbers.length; i++) {
			System.out.print(" " + numbers[i] + " ");
		}
		System.out.println("]");
			
	}
}
