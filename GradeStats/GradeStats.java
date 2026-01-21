//Sanvitti Shah
//Per. 2
//01-15-26
//GradeStats.java
/*Program Description:
 * 
 * This program will take user input and then calculate and print
 * statistics about the given grades
 * 
 * 
 * Working on:
 * arrays
 * nested loops
 * multiple short methods
 * logic 
 */
 
 /**Pseudocode
  * FV array (int) studentScores
  * main
  * 	calls fake main
  * calculateIt() fake main
  * 	call other methods
  * 	getInput()
  * 	call findMin()
  * 	call findMax()
  * 	call findAverage()
  * 	call findMedian()
  * 	call findVeryBadScores
  * 
  * getInput()
  * 	get user input and put it into studentScores
  * 	and use Integer.parseInt() to convert the inputs into int
  * findMin()
  * 	make temp variable
  * 	loop through studentScores and check for minimum 
  * 	tempNumMin = studentScores[0];
  * 	if(tempNumMin < studentScores[i])
  * 		tempNumMin = studentScores[i]
  * findMax()
  * 	make temp variable
  * 	loop through studentScores and check for maximum 
  * 	tempNumMax = studentScores[0];
  * 	if(tempNumMax > studentScores[i])
  * 		tempNumMax = studentScores[i]
  * findAverage()
  * 	make 'average' variable
  * 	loop through studentScores
  * 	average += studentScores[i]
  * 
  * 	outside loop 
  * 	average = average/studentScores.length;
  * 
  * orderNums()
  * 	make temp variable for max
  * 	currentMax = studentScores[0];
  * 	loop through studentScores[]
  * 	for(int i = 1; i < studentScores.length; i++)
  * 		if(currentMax > studentScores[i])
  * 			studentScores[i] = 
  * 			studentScores[studentScores.length-1]=currentMax; //last number in array
  * 		for(int j = 0; j<studentScores.length-1; i++)
  * findMedian()
  * 	using the newly ordered array check if odd length if yes then median is middle number
  * 	if even length find the middle two terms and find their average and thats the median
  * 
  * 
  */

import java.util.Scanner;

public class GradeStats
{
	//Declare all field variables 
		//using more so that printing is easier
	int studentScores [] = new int [20];
	int originalScores [] = new int [20];
	int min;
	int max;
	double average;
	double median;
	String badScores;
	int numBadScores;
	int totalScoreCount;
	
	public GradeStats()
	{
		min=0;
		max=0;
		average=0.0;
		median=0.0;
		badScores = "";
		numBadScores = 0;
		totalScoreCount = 0;
	}
	public static void main(String [] args)
	{
		//use instance of class to call fake main
		GradeStats gs = new GradeStats();
		gs.calculateIt();
	}
	public void calculateIt()	//fake main calls all methods, setting FV values equal to correct methods
	{
		getInput();
		badScores = findVeryBadScores();
		min = findMin();
		max = findMax();
		average = findAverage();
		median = findMedian();
		printEverything();
	}
	public void getInput()		//gets user input and puts it into array and makes duplicate array
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("\n\n\n");
		System.out.println("Hello! Welcome to GradeStats. This program will "+
			"take your input for student's input and it will calculate the "+
			"minimum score, maximum score, median, average, and it will "+ 
			"print all the scores below 75%. \n\n");
			
		String input = "";
		int subscript = 0;
		while(!input.equalsIgnoreCase("Quit"))
		{
				System.out.print("Type in the score. Type \"Quit\" to end the program and print the details -> ");
				input = kb.next();
				
				if(!input.equalsIgnoreCase("Quit"))
				{
					studentScores[subscript] = Integer.parseInt(input);
					subscript++;
				}
				totalScoreCount = subscript;
		}
		for (int h = 0; h < studentScores.length; h++) 
		{
			originalScores[h] = studentScores[h];			//make a duplicate array that holds
															//original value for printing later
		}
	}
	public int findMin()	//to find use a temp number to compare with the rest of the numbers in the array to find the smallest number
	{
		int tempNumMin = studentScores[0];
		for(int i = 0; i < totalScoreCount ; i++)
		{
			if(studentScores[i] < tempNumMin)
			{
				tempNumMin = studentScores[i];
			}
		}
		return tempNumMin;
	}
	
	public int findMax()	//to find max use the same method as findMin just change it so it finds largest number
	{
		int tempNumMax = studentScores[0];
		for(int j = 0; j < totalScoreCount; j++)
		{
			if(studentScores[j] > tempNumMax)
			{
				tempNumMax = studentScores[j];
			}
		}
		return tempNumMax;
	}
	
	public double findAverage()		//to find average add every score and then divide by how many total scores (length)
	{
		double tempAverage;
		for(int b = 0; b < totalScoreCount; b++)
		{
			average += studentScores[b];
		}
		
		average = average/totalScoreCount;
		return average;
	}
	
	public String findVeryBadScores()		//to find scores below 75 (inclusive) go through array and check each number
	{
		String tempBadScores = "";
		for(int a = 0; a< totalScoreCount; a++)
		{
			if(originalScores[a] <=75)
			{
				tempBadScores += "student " + (a+1) + ", ";
				numBadScores++;
			}
		}
		return tempBadScores;
	}
	
	public void orderNums() //to order use nested for loop to check each number with another to put it into the right position
	{
		for (int c = 0; c < totalScoreCount - 1; c++) {
			int minIndex = c;		
			for (int g = c + 1; g < totalScoreCount; g++) 
			{
				if (studentScores[g] < studentScores[minIndex]) 
				{
					minIndex = g; 
				}
			}
			// switch the smallest number found with the number at position c
			int temp = studentScores[minIndex];		//use a temp so that original value is not lost
			studentScores[minIndex] = studentScores[c];
			studentScores[c] = temp;
		}
}

	public double findMedian()
	{	
		orderNums();	//order numbers first then find median
		double medianIn=0.0;
		if(totalScoreCount % 2 ==0) //if number of terms is even 
		{								//find middle avg of middle two terms
			medianIn = (studentScores[totalScoreCount/2]+studentScores[totalScoreCount/2-1])/2.0;
		}
		else 			//if number of terms is odd then divide length by two and round it down to find the index of the median
		{
			medianIn = studentScores[totalScoreCount/2];
		}
		return medianIn;
	}
	
	public void printEverything()
	{
        System.out.println("\nHere is the data you entered:");
        for (int i = 0; i < totalScoreCount; i++) {
            //print out students scores
            System.out.printf("%nStudent %d's score: %d", (i + 1), originalScores[i]);
        }
        
        System.out.printf("%n%nThere were %d students who scored below 75%%: %s.%n%n", numBadScores, badScores);
        
		//print rest of stats
        System.out.printf("%n%-18s %d%n", "Number of scores:", totalScoreCount);
        System.out.printf("%-18s %d%n", "Minimum:", min);
        System.out.printf("%-18s %d%n", "Maximum:", max);
        System.out.printf("%-18s %.1f%n", "Average:", average);
        System.out.printf("%-18s %.1f%n", "Median:", median);
        
        System.out.println("\n\n\n");
    }
}
