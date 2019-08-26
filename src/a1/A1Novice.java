package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//Get input for number of customers
		int numCustomers = scan.nextInt();
		
		//Create arrays to store the first names and last names of customers and the total cost of their items.
		String[] firstNames = new String[numCustomers];
		String[] lastNames = new String[numCustomers];
		double[] totalCosts = new double[numCustomers];
		
		//Record the names of each customer, the items they bought, and calculate how much they spent
		for(int i = 0; i < numCustomers; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			int numItems = scan.nextInt();
			
			//Holds the names of the items that the customer bought.
			String[] itemsBought = new String[numItems];
			
			//Variable to store the total cost of the items purchased by the customer.
			double totalCost = 0;
			
			//Loop through each item the customer bought, record its name and add its cost to the total.
			for(int j = 0; j < numItems; j++) {
				int quantity = scan.nextInt();
				itemsBought[j] = scan.next();
				double price = scan.nextDouble();
				
				totalCost += quantity * price;
			}
			
			//Record the total spent by the customer in the totalCosts array.
			totalCosts[i] = totalCost;
		}
		
		//Input reading is done so the scanner is closed.
		scan.close();
		
		//Print results with the total cost for each customer rounded to two decimal places.
		for (int i = 0; i < numCustomers; i++) {
			System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " + String.format("%.2f", totalCosts[i]));
		}
	}
}
