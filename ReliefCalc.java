/*
*ReliefCalc.java
*
*This project calculates the sum of the cost of supplies, labor, transit, and volunteer solicitation costs.
*
*Zerlyne Nandwani-Simons
*02/23/2024
*CMSC-255-002
*/

import java.util.Scanner;
public class ReliefCalc{
	public static void main(String[] args) {
		// initial declaration of variables
		double supplyCost;
		double laborCost;
		double landTransit;
		double totalCost;
		double totalCost2;

		// create initial constant declaration for volunteer solicitation costs
		final int VOLCOSTS = 50000;

		// get user input for:

		// number of people
		System.out.println("Enter the number of people needing relief:");
		Scanner input = new Scanner(System.in);
		int p = input.nextInt();

		// distance from headquarters
		System.out.println("Enter the distance from headquarters:");
		int d = input.nextInt();

		input.nextLine();

		// whether air transit is required or not
		System.out.println("Is air transportation required?:");
		String airTransit = input.nextLine();

		// create if statement to calculate total cost (supplyCost + laborCost + landTransit)
		if (airTransit.equals("yes")) {
			// calculate supplyCost, laborCost, and landTransit
			supplyCost = (double)1/5 * p;
			laborCost = (double)1/5* p;
			landTransit = d * Math.sqrt(p);
			totalCost = VOLCOSTS + supplyCost + laborCost + landTransit;
			// multiply totalCost by 1/3 and add product to totalCost to get cost including air transportation
			totalCost2 = (totalCost * (double)1/3)+ totalCost;

			// print the total cost
			System.out.printf("Your relief effort will cost $%,.2f ", totalCost2);
			System.out.println();
		}

		// if user says "no" for air transportation, output the original totalCost
		if (airTransit.equals("no")) {
			// calculate supplyCost, laborCost, and landTransit
			supplyCost = ((double)1/5) * p;
			laborCost = ((double)1/5) * p;
			landTransit = d * Math.sqrt(p);
			totalCost = VOLCOSTS + supplyCost + laborCost + landTransit;

			// print the total cost without air transportation
			System.out.printf("Your relief effort will cost $%,.2f ", totalCost);
			System.out.println();
		}

		// get user input for whether or not they'd like to run through the loop again for another cost estimate
		System.out.println("Would you like to create another disaster relief cost estimate? Enter yes to continue");
		String choice = input.nextLine().trim();

		// if user says "yes", run through the same loop as before
		while (choice.equals("yes")) {
			System.out.println("Enter the number of people needing relief: ");
			p = input.nextInt();

			System.out.println("Enter the distance from headquarters: ");
			d = input.nextInt();

			input.nextLine();

			System.out.println("Is air transportation required?:");
			airTransit = input.nextLine();

			supplyCost = ((double)1/5) * p;
			laborCost = ((double)1/5) * p;
			landTransit = d * Math.sqrt(p);
			totalCost = VOLCOSTS + supplyCost + laborCost + landTransit;

			if (airTransit.equals("yes")) {
				totalCost2 = (totalCost * (double)1/3) + totalCost;
				System.out.printf("Your relief effort will cost $%,.2f ", totalCost2);
				System.out.println();
			} else {
				System.out.printf("Your relief effort will cost $%,.2f ", totalCost);
				System.out.println();
			}
			System.out.println("Would you like to create another disaster relief cost estimate? Enter yes to continue");
			choice = input.nextLine().trim();

		}

	}
}