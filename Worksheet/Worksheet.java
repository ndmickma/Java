//Sanvitti Shah
//01-27-26
//Per. 2
//Worksheet.java
/*
 * 
 * 
 * 
 */
 
 /**Pseudocode
  * 
  * import java.util.Scanner;
  * import java.io.File;
  * import java.io.FileNotFoundException;
  * import java.io.PrintWriter;
  * import java.io.IOException;
  * 
  * private FV (3 arrays)
  * 
  * private int [] firstNum;
  * private int [] secondNum;
  * private int [] answer;
  *
  * math.random
  */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
  
public class Worksheet
{
	private int [] firstNum;
	private int [] secondNum;
	private int [] answer;
	
	public Worksheet()
	{
		
	}
	
	public void getInput()
	{
		int small;
		int large;
		Scanner kb = new Scanner(System.in);
		System.out.println("\n\n\nWelcome to Worksheet.java! This program will "+
			"prompt you for information and then build a math worksheet based on your input!");
		System.out.print("Please enter the smallest number -> ");
		small = kb.nextInt();
		System.out.print("Please enter the largest number -> ");
		large = kb.nextInt();
		for(int i = 0; i<20; i++)
		{
			firstNum[i] =(int)(Math.random()*small+large);
			secondNum[i] = (int)(Math.random()*small+large);
		}		
	}
	
	public void calculateAndPrint()
	{
		char symbol;
		for(int i = 0; i<20; i++)
		{
			if((int)(Math.random()*1+2) == 1)	//if 1 then use +
			{
				answer[i] = firstNum[i] + secondNum[i];		
				symbol = '+';
			}
			else  			//if 2 use - 		
			{
				answer[i] = firstNum[i] - secondNum[i];
				symbol = '-';
			}
		}
	}
}
