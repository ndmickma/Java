//UnitConverterTester1.java
//This program works with UnitConverter1. It will create an instance of
//UnitConverter and call all of the methods in that class.

public class UnitConverterTester1 	//class header
{
	public UnitConverterTester1()
	{
	}

	public static void main (String [] args)
	{
		UnitConverter1 uConvert1 = new UnitConverter1();
		
		double feet = -1.2;
		double yards = -0.5;
		//double miles = -0.5;
		double cm = -0.5;
		
		uConvert1.getInches();
		feet = uConvert1.inchesToFeet(); //use the instance of class to call methods
		yards = uConvert1.feetToYards(feet);
		//miles = uConvert1.convertFeetToMiles(feet);
		cm = uConvert1.inchesToCm();
		uConvert1.print(feet, yards, cm);
	}
}
