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
 * double grandtotal = subtotal + TaxAmount
 * print it out
 * print out closing statement with println
 * 
 * Testing plan:
 * input 100 200 300
 * output 
 * subtotal is 600
 * discount is 60
 * total before tax is 540
 * tax is 49.28
 * grand total is 589.28
 */
 
 import java.util.Scanner;
 
public class BookBuyers
{
	public static void main(String args [])
	{
		final double TAX = 0.09125;
		final double DISCOUNT = 0.10;
		 
		Scanner scanner = new Scanner(System.in);
		 
		double CostCalc = 0.0;
		double CostEngl = 0.0;
		double CostHist = 0.0;
		double subtotal = 0.0;
		double disc = 0.0;
	
		
		 
		System.out.print("\n\n\n");
		System.out.print("This program will calculate the cost of books "
			+"for two people. Please enter the costs for Calculus, "
			+"English, and History for one person, seperated by tabs: ");
		CostCalc = 2*scanner.nextInt();
		CostEngl = 2*5*scanner.nextInt();
		CostHist = 2*2*scanner.nextInt();
		subtotal = CostCalc + CostEngl + CostHist;
		disc = subtotal*DISCOUNT;
		
	}
}
	
		 
 
