package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Get input for number of items
		int numItems = scan.nextInt();
		
		//Create arrays to store the names and prices of each item.
		String[] itemNames = new String[numItems];
		double[] itemPrices = new double[numItems];
		
		//Populate the arrays with information about the items
		for(int i = 0; i < numItems; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}
		
		//Get input for number of customers
		int numCustomers = scan.nextInt();
		
		//Create arrays to store the first and last names of each customer.
		String[] firstNames = new String[numCustomers];
		String[] lastNames = new String[numCustomers];		
		
		//array to hold the total money spent for each customer
		double[] totalSpent = new double[numCustomers];
				
		//Loop through each customer
		for(int i = 0; i < numCustomers; i++) {
			//Populate the arrays with information about the customers
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			
			//Get input for number of items bought by the customer
			int numBought = scan.nextInt();
			
			//variable to hold total money spent by this customer
			double totalCost = 0; 
			
			for(int j = 0; j < numBought; j++) {
				//Update the total cost by adding the contribution of this item to the total cost
				int quantity = scan.nextInt();
				String itemName = scan.next();
				//Find the price of the item by referencing the itemPrices array
				double itemCost = itemPrices[indexOf(itemName, itemNames)];
				totalCost += quantity * itemCost;
			}
			
			//Put the money spent by the customer into the array.
			totalSpent[i] = totalCost;
		}
		
		//Input is finished
		scan.close();
		
		//Calculate the customer who spent the most, the one who spent the least, and the average spent by each customer
		//and display the results
		
		//Find the indexes of the customers who spent the most and who spent the least.
		int indexBiggest = findIndexMax(totalSpent);
		int indexSmallest = findIndexMin(totalSpent);
		
		//calculate and round the max spent, the min. spent, and the average spent by the customers.
		String avgSpent = String.format("%.2f", findAvg(totalSpent));
		String maxSpent = String.format("%.2f", totalSpent[indexBiggest]);
		String minSpent = String.format("%.2f", totalSpent[indexSmallest]);
		
		//Print the results
		System.out.println("Biggest: " + firstNames[indexBiggest] + " " + lastNames[indexBiggest] + " (" + maxSpent + ")");
		System.out.println("Smallest: " + firstNames[indexSmallest] + " " + lastNames[indexSmallest] + " (" + minSpent + ")");
		System.out.println("Average: " + avgSpent);
	}
		
		/* findIndexMax
		 * Finds and returns the index of the maximum value in an array of doubles
		 * 
		 * Input: Array of doubles
		 * 
		 * Output: Integer index of the maximum value
		 * 
		 * Preconditions: Input array must not be null and must contain at least one value.
		 */
		static int findIndexMax(double[] a) {
			//Initialize current index of max value to be at index 0
			int indexMax = 0;
			
			//Replace the value of indexMax if the value of the array at that index is greater.
			for (int i = 0; i < a.length; i++) {
				if (a[i] > a[indexMax]) {
					indexMax = i;
				}
			}
		
			return indexMax;
		}
		
		/* findIndexMin
		 * Finds and returns the index of the minimum value in an array of doubles
		 * 
		 * Input: Array of doubles
		 * 
		 * Output: Integer index of the minimum value
		 * 
		 * Preconditions: Input array must not be null and must contain at least one value.
		 */
		static int findIndexMin(double[] a) {
			//Initialize current index of min value to be at index 0
			int indexMin = 0;
			
			//Replace the value of indexMin if the value of the array at that index is greater.
			for (int i = 0; i < a.length; i++) {
				if (a[i] < a[indexMin]) {
					indexMin = i;
				}
			}
		
			return indexMin;
		}
		
		/* findAvg
		 * Finds and returns the average of the values in an array of doubles
		 * 
		 * Input: array of doubles
		 * 
		 * Output: the average as a double
		 * 
		 * Preconditions: Array must not be null and must contain at least one value
		 */
		static double findAvg(double[] a) {
			double total = 0;
			int length = a.length;
			for(int i = 0; i < length; i++) {
				total += a[i];
			}
			return total/length;
		}
		
		/* indexOf
		 * Finds and returns the index of a given string in a given array of Strings
		 * 
		 * Input: String, array of Strings
		 * 
		 * Output: Integer index in which the String first appears.
		 * 
		 * Preconditions: Input array must contain at least one value. Returns -1 if input String is not in the array.
		 */
		static int indexOf (String key, String[] a) {
			for(int i = 0; i < a.length; i++) {
				if(a[i].equals(key)) {
					return i;
				}
			}
			return -1;
		}
}
