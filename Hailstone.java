//Sanvitti Shah
//11-06-25
//Hailstone.java
/*Program description
 * 
 */
 
import java.util.Scanner;
public class Hailstone
{
	 private int input;		//Field variable to store input
	 private int count;		//FV to keep track of count
	 
	 public Hailstone()		//Constructor to initialize FV
	 {
		 input = -1;		//Set equal to smth it can't be
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
			 count++;						//add to count everytime loop runs
			 System.out.println("\n\n\n");	//3 blank lines
			 System.out.print("Welcome to Hailstone Game! FINISH PROMPT");
			 System.out.print("Enter a positive integer (1- 10000). To quit, enter -1:	");
					//Prompt user
			 input = kb.nextInt();	//put user input into var input
			 if(input < -1 || input > 10000)	//check  to if input is valid
				System.out.println("\nEnter a value within the range, please!");
						//print error message
			else
			
		 } while((input<0 && input != -1)||(input > 10000 && input != -1));//keep running loop if input is invalid
														   //if it's valid keep running loop		 
	 }
	 
	 public void print()	   //create print()
	 {
		 while(input > 1);	  //use while loop because if input = -1 don't print anything
		 {
			 System.out.print(input);	//print input at the start so that
										//original input is printed
			 if(input % 2 == 0)			//check if even
				input = input/2;		//divide by 2
			 else                       
				input = input*3 + 1;	//multiply by 3 and add one if odd
		 }
		 
		 
	 }
	 
	 public void findIt()	   //create findIt()
	 {
		while(input != -1)
			 input();		   //call input()	
			 print();	       //call decide()
		   //keeping going until input != -1
			 
	 }
}
	 
	 
