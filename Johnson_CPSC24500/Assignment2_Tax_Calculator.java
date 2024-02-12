import java.util.Scanner;
import java.util.InputMismatchException;
public class Assignment2_Tax_Calculator {

	public static int taxBracket(double income) {
		int tax = 0;
		if(income <= 4000 ) {
			// No tax
			return tax;
		} else if(income <= 5500){
			// 10% tax
			double taxable_amount1 = income - 4000;
			tax = (int) (taxable_amount1 * .10);
			return tax;
		} else if (income <=33500) {
			// 20% tax
			double taxable_amount1 = 5500 - 4000;
			double taxable_amount2 = income - 5500;
			tax = (int) (taxable_amount1 * .10 + taxable_amount2 * .20);
			return tax;
		} else {
			double taxable_amount1 = 5500 - 4000;
			double taxable_amount2 = 33500 - 5500;
			double taxable_amount3 = income - 33500;
			tax = (int) (taxable_amount1 * .10 + taxable_amount2 * .20 + taxable_amount3 * .40);
			return tax;
		}
	}
	
	
	public static void main(String[] args) {
		//initialize variables
		double income = 0;
		boolean input = false;
		
		// get input: name and income
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = scan.next();
		while (!input) {
			try {
				System.out.println("How much money did you earn?: ");
				income = scan.nextDouble();
				if (income >= 0) {
					input = true; //exit loop
				} else {
					System.out.println("Invalid input");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
				//scan.next();
			}
		}
		
		// call function
		int tax = taxBracket(income);
		
		// print output
		System.out.println("Name: " + name);
		System.out.println("Income: " + income);
		System.out.println("Income tax: " + tax);
	}
}
