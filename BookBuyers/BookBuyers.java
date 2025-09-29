//Sanvitti Shah
//09-18-25
//Per. 2
//BookBuyers.java
/*Description of program
 * calculate cost of books for two people
 * 
 * 
 * Working on:
 * printf
 * formatting/aligning
 * math 
 * using Scanner for inputs
 */
 
/** Pseudocode
 * import scanner
 * class header
 * make main
 * create final double TAX = 0.09125
 * create final double DISCOUNT = 0.10
 * create scanner 
 * make double CostCalc = 0.0;
 * make double CostEngl = 0.0;
 * make double CostHist = 0.0;
 * ask the user to enter the costs for Calculus, English, and History
 * store the responses in their respective variables
 * CostCalc = 2*
 * CostEngl = 5*2*
 * CostHist = 2*2*
 * print them out
 * add CostCalc + CostEngl + CostHist and put into variable double subtotal
 * do subtotal*DISCOUNT
 * and place into double disc
 * print it out
 * double notax = subtotal-disc
 * print it out
 * double TaxAmount = notax*TAX
 * print it out
 * double grandtotal = notax + TaxAmount
 * print it out
 * print out closing statement with println
 * 
 * Testing plan:
 * input 100 200 300
 * output 
 * calculus books is 200
 * english books is 2000
 * history books is 1200
 * subtotal is 3400
 * discount is 340
 * total before tax is 3060
 * tax is 279.23
 * grand total is 3339.23
 */
 
 
 import java.util.Scanner;
 
public class BookBuyers
{
	public static void main(String [] args)
	{
		final double TAX = 0.09125;
		final double DISCOUNT = 0.10;
		 
		Scanner scanner = new Scanner(System.in);
		 
		double CostCalc = 0.0;
		double CostEngl = 0.0;
		double CostHist = 0.0;
		double subtotal = 0.0;
		double disc = 0.0;
		double notax = 0.0;
		double TaxAmount = 0.0;
		double grandtotal = 0.0;
	
		
		 
		System.out.print("\n\n\n");
		System.out.print("This program will calculate the cost of books "
			+"for two people. Please enter the costs for Calculus, "
			+"English, and History for one person, seperated by tabs: ");
		CostCalc = 2*scanner.nextDouble();
		CostEngl = 2*5*scanner.nextDouble();
		CostHist = 2*2*scanner.nextDouble();
		subtotal = CostCalc + CostEngl + CostHist;
		disc = subtotal*DISCOUNT;
		notax = subtotal-disc;
		TaxAmount = notax*TAX;
		grandtotal = notax+TaxAmount; //when I test it, it rounds to the hundreth for grandtotal but doesn't round for TaxAmount
		
		System.out.printf("\n%-20s =  $ %,10.2f", "Calculus books", CostCalc);
		System.out.printf("\n%-20s =  $ %,10.2f", "English books", CostEngl);
		System.out.printf("\n%-20s =  $ %,10.2f", "History books", CostHist);
		System.out.printf("\n%-20s =  $ %,10.2f", "Sub total", subtotal);
		System.out.printf("\n%-20s =  $ %,10.2f", "Discount", disc);
		System.out.printf("\n%-20s =  $ %,10.2f", "Total before tax", notax);
		System.out.printf("\n%-20s =  $ %,10.2f", "Tax", TaxAmount);
		System.out.printf("\n%-20s =  $ %,10.2f", "Grand total", grandtotal);
		
		System.out.print("\n\nThe total cost for 16 books is " + grandtotal+
			". Thank you for shopping with BooksRUs.com.");
	}
}
	
		 
 

