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
/**Pseudocode
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
  *		after the loop print ending 3 blank lines
  * void getString()
  * 	use scanner to ask user for a string + 3 blank lines
  * 	set their input equal to line
  *	void encryptString()
  * 	make an empty string called encrypted 
  * 	use a for loop to go through line
  * 		if((int)(line.charAt(i))>=65 && (int)(line.charAt(i))<=90 || (int)(line.charAt(i)) >=97 && (int)(line.charAt(i))<=122) //if it is a letter
  * 			add 2 to ASCII value and then add that char to encrypted
  * 			one "loop" for uppercase and one for lowercase
  * 			if(line.charAt(i).equals('Y') || line.charAt(i).equals('Z') || line.charAt(i).equals('y') || line.charAt(i).equals('z'))
  * 				subtract 24 from ASCII and add it to encrypted		
  * 		else statement (if not letter) 
  * 			add to encrypted
  * 	encrypted = line
  * void printString(int counterIn)
  * 	use printf to print statement and use counterIn to print the 
  * 	message 
  * 		
 **/
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
			encryptString();	//call encryptString inside the loop so that it encrypts 13 times
			printString(counter);	//call printString inside the loop so it can print 13 times
									//pass in counter for the parameter
		}
		System.out.println("\n\n\n");
	}
	public void getString()
	{
		Scanner kb = new Scanner(System.in);	//create scanner
		System.out.println("\n\n\n");			//3 blank lines
		System.out.print("Welcome to Encrypt, this program will encrypt any message by shifting it by 2 to hide your message.\n"
			+"Please enter a word or phrase you want to be encrypted -> ");	//print prompt
		line = kb.nextLine();		//get user input and set it equal to line
	}
	public void encryptString()
	{
		String encrypted = new String("");		//create empty string to hold values while they get shifted
		for(int i =0; i<line.length(); i++)	//make a for loop to run through line
		{
			if(((int)(line.charAt(i))>=65 && (int)(line.charAt(i))<=90)||((int)(line.charAt(i))>=97 && (int)(line.charAt(i))<=122))
											//check if it's a letter
			{
				if((line.charAt(i))=='Y' || (line.charAt(i))=='Z' || (line.charAt(i))=='y' || (line.charAt(i))=='z')
					encrypted += (char)(((int)line.charAt(i))-24); //if it is one of these letters,
																	//adding 2 will push it over and 
																	//make it a character not a letter 
																	//so subtract 24 to get to the right letter
				else
					encrypted += (char)(((int)(line.charAt(i))) + 2);	//if it won't get pushed over add two and add it to encrypted
			}
			else
				encrypted += (char)((int)(line.charAt(i))); //if it is a character add to encrypted as it is
		}
		line = encrypted;	//line = encrypted
		
	}
	public void printString(int counterIn) //counterIn is parameter so that the encryption # can be printed
	{
		System.out.printf("\nEncryption %d:\n%s\n",counterIn,line);
	}
	
}

