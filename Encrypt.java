//Sanvitti Shah
//01-08-26
//Per. 2
/*Encrypt.java
 * Working on:
 * Scanner
 * loops
 * string methods
 * multiple methods
 * printf
 * 
 * Program description:
 * takes user input (String) and shifts it by two until you get the original sentence.
 */
 /**
  * PUT IN THREE BLANK LINES SOMEWHERE
  * import scanner
  * class header
  * declare field variable 
  * write constructor
  * 	intitalize FV variable line
  * main 
  * 	call rotate13Times
  * fake main named rotate13Times()
  * 	counter is from for loop
  * 	calls getString(), encryptString(), printString(counter)
  * 	contains for loop that runs 13 times but getString() is outside loop
  * void getString()
  * 	use scanner to ask user for a string
  * 	set their input equal to line
  *	void encryptString()
  * 	make an empty string called encrypted 
  * 	use a for loop to go through line
  * 	if
  * 		add 2 to ASCII value and then add that char to encrypted
  * 		one loop for uppercase and one for lowercase
  * 	if((int)'Y'>90 || (int) 'Z'>90) subtract 24 from ASCII
  * 	if((int) 'y'>123 || (int)'z'>123 subtract 24 from ASCII
  * 	encrypted = line
  * 
  * 	else statement if not letter 
  * 		add to encrypted
  * void printString(int counterIn)
  * 	use printf to print statement and use counterIn to print the 
  * 	right message
  * 		
  */
 
import java.util.Scanner;		//import scanner
public class Encrypt
{
	String line;				//Declare FV
	public Encrypt()
	{
		line = new String("");	//Initialize FV
	}
	
	public static void main(String [] args)
	{
		Encrypt en = new Encrypt();		//make instance of class
		en.rotate13Times();		//use instance to call fake main
	}	
	public void rotate13Times()		//fake main
	{
		getString();		//call getString first so that user input is not asked everytime
		for(int counter=1; counter<=13; counter++)	//run 13 times
		{
			encryptString();
			printString(counter);		
		}
	}
	public void getString()
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("\n\n\n");
		System.out.print("Please enter a word or phrase you want to be encrypted ->");
		line = kb.nextLine();
	}
	public void encryptString()
	{
	}
	
}

