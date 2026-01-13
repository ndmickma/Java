//Sanvitti Shah
//01-12-26
//Per. 2
//GrowthPattern.java
/* Program description
 * This program tracts the growth of a plant. It will take a user input
 * for the data and then print out 
 * 
 * 
 * 
 * Working on
 * arrays
 * 
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
  * 	
  * 
  * 
  * printRate
  * calculate average growth
  * System.out.println("The average growth rate is") - use printf and round to 2nd decimal so .2f
  */
public class GrowthPatterns
{
	public GrowthPatterns()
	{
	}
	public static void main(String [] args)
	{
	}
	
}
