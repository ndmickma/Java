//Sanvitti Shah
//09-04-25 Per. 2
//Schedule.java
/*Description of program
 * output school schedule
 * 
 * 
 * Working on:
 * printf
 * Format.java
 */
 
 public class Schedule
 {
	 public static void main (String args[])
	 {
		 System.out.println("\n\n\n");
		 String first = "Alg2/Trig";
		 String second = "Java";
		 String third = "PE 9";
		 String fourth = "French 2";
		 String fifth = "Biology";
		 String sixth = "B Choir";
		 String seventh = "Lit/Writ";
		 String heading= "Course Schedule for:";
		 String name = "Sanvitti Shah";
		 String period = "Period";
		 String course = "Course";
		 String bill = new String("Outstanding bill:");
		 double amount = 34.56789;
		 byte one = 1;
		 
		 //heading
		 System.out.println(Format.center(heading, 50));
		 System.out.println(Format.center(name, 50));
		 //subtitles
		 System.out.println(Format.left(period,25)+ Format.right(course,25));
		 //first period
		 System.out.printf("%d %48s", one, first);
		 //second period
		 System.out.printf("\n%d %48s", 2, second);
		 //third period
		 System.out.printf("\n%d %48s", 3, third);
		 //fourth period
		 System.out.printf("\n%d %48s", 4, fourth);
		 //fifth period
		 System.out.printf("\n%d %48s", 5, fifth);
		 //sixth period
		 System.out.printf("\n%d %48s", 6, sixth);
		 //seventh period
		 System.out.printf("\n%d %48s", 7, seventh);
		 //outstanding bill
		 System.out.printf("\n%s %s%.2f", bill, "$", amount);
		 System.out.println("\n\n\n");
	 }
 }	 
	 
