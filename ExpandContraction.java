//Sanvitti Shah
//Per. 2
//01/05/26
//ExpandContraction.java
/*
 * Description of program:
 * 	Gets user input for contracted word
 * 	Prints out expanded word
 * Working on:
 * 	String methods
 * 	loops
 * 	multiple methods
 */
import java.util.Scanner;
public class ExpandContraction
{
	private String contracted;
	private String expanded;	
	private Scanner kb;
	public ExpandContraction() //this is the constructor
	{
		kb = new Scanner(System.in);
	}
	public static void main(String [] args)
	{
		ExpandContraction ec = new ExpandContraction();
		ec.expandIt();
	}
	public void expandIt ()
	{
		do
		{
			getInput();
			processString();
			printResult();
			System.out.println("Would you like to expand another contraction? Type Quit to stop");
		}while(!((kb.next).equals("Quit"));
	}
	public void getInput()
	{
		System.out.println("What contraction would you like to expand?");
		contracted = kb.next();
	}
	public void processString()
	{
		if((contracted.substring(2)).("can"))
			expanded = "can not";
		else if((contracted.substring(2)).equals("won"))
			expanded = "will not";
		else if((contracted.substring(2)).equals("sha"))
			expanded = "shall not";
		else
		{
			if(contracted.endswith("n't"))
			{
				expanded = contracted.substring(0,contracted.lastIndexOf('n'));
			}
			else
			{
				System.out.print("That word is already fully expanded!");
			}
		}
	}
	public void printResult()
	{
		System.out.println("");
	}
}
