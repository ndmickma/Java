//Sanvitti Shah
//11-06-25
//Hailstone.java
/*Program description
 * gets user input for num
 * preforms algorithm based on type of num (odd or even)
 * sentinel val of -1
 * 
 * Working on:
 * loops:
 * 		while loops
 * 		do while loops
 * if-else
 * instances of classes
 * no printing in main 
 * multiple methods
 * sentinel values
 */
 
import java.util.Scanner;
public class Hailstone
{
	 private int input;		//Field variable to store input
	 private int count;		//FV to keep track of count
	 
	 public Hailstone()		//Constructor to initialize FV
	 {
		 input = -2;		//Set equal to smth it can't be
		 count = 1;
	 }
	 
	 public static void main(String [] args)
	 {
		 Hailstone hs = new Hailstone();	//Instance of class
		 hs.findIt();						//use instance to call findIt()
	 }
	 
	 public void input()
	 {
		 Scanner kb = new Scanner(System.in); //create scanner
		 
		 do                                   //use do while to get input
		 {
			 System.out.print("Enter a positive integer (1 - 10000). To quit, enter -1: ");
					//Prompt user
			 input = kb.nextInt();	//put user input into var input=
			 if((input < -1 || input > 10000) || input == 0)	//check  to if input is valid
				System.out.println("\nEnter a value within the range, please!\n\n");
						//print error message
			
		 } while((input < 0 || input > 10000) && input != -1); //(input<0 && input != -1)||(input > 10000 && input != -1));//keep running loop if input is invalid
														   //if it's valid keep running loop		 
	 }
	 
	 public void print()	   //create print()
	 {
		 if (input != -1 && input != 0)
			System.out.print(input + "\t"); //print first num with tab 
 		 while(input > 1)	  //use while loop because if input = -1 don't print anything
		 { 			
										//original input is printed
			 if(input % 2 == 0)	
			 {		//check if even
				input = input/2;		//divide by 2
				count++;				//count + 1
			 }			
			 else 
			 {
			                       
				input = input*3 + 1;	//multiply by 3 and add one if odd
				count++;				//count + 1
			 }			
		 	 System.out.print(input + "\t");	//print rest of the nums spaced with tabs
		 	 if(count % 10 == 0)
				System.out.println();		//new line when 10 numbers are printed

		 }
		 if(input == 1)
			System.out.print("\n\nThe loop excecuted "+ count + " times.\n\n\n");
		 count = 1;						//reset count after printing
										//make it = 1 becuase do while always runs once
										
		 if(input == -1)
		 {
			System.out.println("Thank you for playing Hailstone!");	//outro msg
			System.out.println("\n\n\n");			//3 blank lines
		 }
	 }
	 
	 public void findIt()	   //create findIt()
	 {
		System.out.println("\n\n\n");	//3 blank lines
		System.out.println("Welcome to Hailstone! This game will take"		//intro msg
				+" a number from you and it will preform an algorithm that"
				+" ultimately ends up with the numbers 4 2 1. Have fun!\n");
		 
		while(input != -1)      //keeping going until input != -1
		{
			 input();		   //call input()	
			 System.out.println();	//print blnk line so spacing looks better
			 print();	       //call decide()
		  
		} 
	 }
}
	 
	 

