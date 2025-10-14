//Sanvitti Shah
//10-14-25
//Per. 2
//Roll.java
/*Description of program
 * randomly selects number (35 or 36)
 * 
 * Working on:
 * Math.random
 * multiple classes
 * 
*/

public class Roll
{
	public Roll()
	{
	}
	public int rollStave()
	{
		int rollOut = (int) (Math.random()*2+35);
		return rollOut;
	}
}
		

