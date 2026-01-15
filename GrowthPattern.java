//Sanvitti Shah
//01-12-26
//Per. 2
//GrowthPattern.java
/* Program description
 * This program tracts the growth of a plant. It will take a user input
 * for the data and then print out a histogram based on the rates. At 
 * the end it will print out a message stating average growth rate.
 *
 * Working on
 * arrays
 * multiple methods
 * limited field variables
 * indexes
 * logic
 */
 /**
  * import scanner
  *	class header 
  * declare field variable height array length
  * constuctor
  * growIt() (fake main)
  * 	call these methods in a loop so they run over
  * 	and over until all terms
  * 	call decideSymbols()
  * 	call printSymbols()
  * 	these methods are not in the loop becuase they only run once
  * 	call printRate() (runs last)
  * 	call getInput() (runs first)
  * getInput()
  * 	make scanner
  * 	prompt user for data
  * 	place user input into array
  * return char decideSymbols()
  * char symbol;
  * for loop that runs through array- for(int index=0; index <= height[].length; index++)
  * 	if(index != 0)
  * 		if(height[index] > height[index-1])
  * 			for(int more=1; more<= height[index]; more++)
  * 				symbol += '+'
  * 				return symbol;
  * 		if(height[index] < height[index-1])
  * 			for(int less=1; less< height[index]; less++)
  * 				symbol +='-';
  * 				return symbol;
  * 	else
  * 		for(int equal=1; equal < height[index]; equal++)
  * 			symbol += 'o';
  * 			return symbol;
  * printSymbols
  * 	if(height[index] > height[index-1])
  * 			for(int more=1; more<= height[index]; more++)
  * 				System.out.print(
  * 		if(height[index] < height[index-1])
  * 			for(int less=1; less< height[index]; less++)
  * 				symbol +='-';
  * 				return symbol;
  * 	else
  * 		for(int equal=1; equal < height[index]; equal++)
  * 			symbol += 'o';
  * 			return symbol;
  * 
  * 
  * printRate
  * calculate average growth
  * System.out.println("The average growth rate is") - use printf and round to 2nd decimal so .2f
  */

import java.util.Scanner;

public class GrowthPattern
{
    private int[] height;		// field variable array called height

    public GrowthPattern()
    {
        //nothing to initialize because user input goes into array
    }

    public static void main(String[] args)
    {
        GrowthPattern gp = new GrowthPattern();  // create an instance of the class to call the fake main 
        gp.growIt();
    }
	
    public void growIt()					// fake main 
    {
        System.out.println("\n\n\n");		 // 3 blank lines at the start
        getInput();      					// get user input first
        System.out.println("\n\n");			//print extra lines for spacing
             
        for (int i = 0; i < height.length; i++)	// loop through the array to print the histogram
        {
            char symbol;
            int count;
            if (i == 0)
            {
                symbol = 'o';			// use 'o' for the first row
                count = 5 + height[i];		 // first row always uses 5 + value
            }
            else
            {
                symbol = decideSymbols(height[i], height[i - 1]);	// decide symbol based on change from previous 
                
                if (height[i] == height[i - 1])	 // if there is no change, print 5 + current height
                {
					count = height[i];
                }
                else
                {
                    count = Math.abs(height[i] - height[i - 1]);	// i growth or shrinkage, print only the difference
                }
            }
            
            printSymbols(i, count, symbol); 	 // print the row for this time
        }
        
        printRate();		// calculate and print the final rate
        System.out.println("\n\n\n");	// 3 blank lines at the finish
    }
    
    public void getInput() 		// method to handle user input 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Hello! Welcome to GrowthPattern. This program will"+
			" take your input on plant measurments and track it's growth.\n\n"+
			"How many times did you measure the plant (length of array)? ");
        int size = input.nextInt();       
        height = new int[size];		 // initialize the field variable array
        System.out.println("\nEnter the height measurements (in mm) in order:");
        
        for (int j = 0; j < height.length; j++)
        {
            System.out.print("Time " + j + ": ");
            height[j] = input.nextInt();
        }
    }

    public char decideSymbols(int current, int previous)    //decides if we use +, -, or o
    {
        if (current > previous)		// if the value is higher than the one prior, use '+'
        {
            return '+'; 
        }
        else if (current < previous)		 // if it is less, use '-' 
        {
            return '-'; 
        }
        else          // if there is no change, use 'o'
        {
            return 'o'; 			
        }
    }

    // method to print symbols 
    public void printSymbols(int time, int count, char sym)
    {
        // create the time string so that t0, t1, t2 is printable
        String timeIn = "t" + time;
        
        // print the time label left justified in field of 5
        System.out.printf("%-5s", timeIn);

        // loop to print the symbols based on the count calculated in growIt
        for (int k = 0; k < count; k++)
        {
            System.out.print(sym);
        }
        System.out.println(); // move to the next line
    }
    
    
    public void printRate()  // calculates and print the rate of growth 
    {
        if (height.length < 2)
        {
            System.out.println("Not enough data to calculate rate.");
            return;
        }

        int last = height.length - 1;		// rate of growth = change in height / total time
        double changeInHeight = height[last] - height[0];	 // change in height is last value minus first value 
        double totalTime = last; 	 // total time is the last index in height because time starts at zero
        double rate = changeInHeight / totalTime;
        System.out.println();
        System.out.printf("The average growth rate is: %.2f mm/unit\n", rate); 	        // print rate to two decimal places
    }
}
