//Sanvitti Shah
//Per. 2
//11-10-25
/*NumberSequence1.java
 * 
 * 
 * 
 * 
 */
 
import java.util.Scanner;
public class NumberSequence1
{
	int num, constant, inputNum;
	String inputPattern;
	
	public NumberSequence1
	{
		num = -20;
		constant = 0;
		imputNum = -20;
		inputPattern = "modulus 500";
	}
	public static void main(String [] args)
	{
		playGame();
	}
	
	public void generateNums()
	{
		System.out.println("\n\n\n");
		System.out.print("Welcome to NumberSequence! This game will print"+
			" out a random sequence and you will have to guess the next"+
			" term AND the pattern! Good luck!!!");
		constant = (int)(Math.random()*10+11);
		num = (int)(Math.random()*21-10);
		for(int i = 1 ; i<=5; i++)
		{
			System.out.print(num+ ",");
			num = num + constant; 
			if(i==5)
				System.out.print("___");
		}
	}
	
	public void getInput()
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("PROMPT USRERERRE");
	}
	public void playGame()
	{
		
	}
	
	
	
} 
