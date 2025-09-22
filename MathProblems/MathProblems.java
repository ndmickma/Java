//Sanvitti Shah
//09-02-25 
//Per. 2
//MathProblems.java
/*Description of program
 * Declares and initializes variables, stores the results of an expression
 * in avariable, then prints the variable using println as well as printf
 * and Fomat to print a double to two places, ints and a char.
 * 
 * Working on:
 * Declare and initialize variables, formatting using printf and Format
 */
 
 public class MathProblems
 {
	 public static void main (String args [])
	 {
		 
		 double prob1; //this declares prob1 as a double
		 prob1 = -1.0; //this initializes prob1 as -1.0 (something that
			//can't equal in the program) we could have also just used 
			//double prob1 = -1.0;
		int prob2 = -1000; //declare prob2
		char prob3 = '^';
		int prob4 = -1;
		double prob5 = -1.00;
		
		
		prob1= 5.6*17/3-49%11/2;
		
		System.out.println("\n\n\n");
		System.out.println("1) 5.6*17/3-49%11/2 = " + Format.left(prob1, 5, 2));
		System.out.printf("1) 5.6*17/3-49%%11/2 = %-5.2f%n", prob1);
		
	
		//prob3 goes here
		
		prob3= (char)(56/2+17*3-9%9);
		
		System.out.println("\n");
		System.out.println("3) 56/2+17*3-9%9 = " + Format.left("'" + prob3 + "'",5));
		System.out.printf("3) 56/2+17*3-9%%9 = %-5s%n", "'" + prob3 + "'");
		
		//prob4 goes here
		
		prob4= (int)((double)9/12*3-6.5);
		
		System.out.println("\n");
		System.out.println("4) 9/12*3-6.5 = " + Format.left(prob4,5));
		System.out.printf("4) 9/12*3-6.5 = %-5d%n", prob4);
		
		//prob5 goes here
		
		prob5= (int)('g')+(double)('2')/7;
		
		System.out.println("\n");
		System.out.println("5) 103 + 50/7 = " + Format.left(prob5, 5,3));
		System.out.printf("5) 103 + 50/7 = %-5.3f%n", prob5);
		System.out.println("\n\n\n");
		
		
		
	}
}

		 
 

