package a1;

import java.util.Scanner;

public class A1Jedi {

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
		
		//Arrays to store how many of each item was bought, and how many distinct customers bought each item.
		int[] quantBought = new int[numItems];
		int[] quantCustomers = new int[numItems];
				
		//Loop through each customer
		for(int i = 0; i < numCustomers; i++) {
			//Populate the arrays with information about the customers
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			
			//Get input for number of items bought by the customer
			int numBought = scan.nextInt();
			
			//variable to hold total money spent by this customer
			double totalCost = 0; 
			
			// array to hold whether the customer has been counted as buying a specific item or not; to avoid counting an
			// item more than once. Default values are all false.
			boolean[] counted = new boolean[numItems]; 
			
			// Loop updates the total cost by adding in the cost due to each item and
			// updates the quantBought and quantCustomers arrays by identifying each item and updating the arrays accordingly.
			for(int j = 0; j < numBought; j++) {
				int quantity = scan.nextInt();
				String itemName = scan.next();
				
				//Find the index of the item in the itemNames array
				int itemIndex = indexOf(itemName, itemNames);
				
				//Find the price of the item by referencing the itemPrices array
				double itemCost = itemPrices[itemIndex];
				
				//update the total money spent by the customer
				totalCost += quantity * itemCost;
				
				//Update the quantity bought for this item.
				quantBought[itemIndex] += quantity;
				
				// Update the amount of customers who bought this item.
				if(!counted[itemIndex]) {
					quantCustomers[itemIndex] += 1;
					
					//To avoid counting an item more than once, record that it has been counted in the counted array.
					counted[itemIndex] = true;
				}
			}
			
			//Put the money spent by the customer into the array.
			totalSpent[i] = totalCost;
			
		}
		
		//Input is finished
		scan.close();
		
		//Print relevant results
		for(int i = 0; i < numItems; i++) {
			if(quantBought[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			}
			else {
				System.out.println(quantCustomers[i] + " customers bought " + quantBought[i] + " " + itemNames[i]);
			}
		}

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
