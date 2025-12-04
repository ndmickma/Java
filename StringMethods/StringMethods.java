//Sanvitti Shah
//12-02-25
//Per. 2
/* charAt()
 * trim()
 * lastIndexOf(char a)
 */

public class StringMethods
{
	public static void main(String [] args)
	{
		System.out.print(charAt("hello", 3));		
	}
	
	public static char charAt(String s, int x)
	{
		int difference=0;
		int num=0;
		s = s.substring(x, x+1);
		difference = s.compareTo(" ");
		num = difference + 32;
		char c='?';
		c = (char)(num);
		return c;
	}
	
	//public static String trim(String str)
	//{
		//String result = new String("n");
		//int position = 0; 
		//while(charAt(str, position).equals(" "))
		//{
			//str = substring(position+1);
			//if(charAt(str,position).equals(" ")== false)
			//{
				//while((charAt(str,position+str.length()+1)).equals(" "))
				//{
					//str = substring(0,str.length()+1);
				//}
			//}
		//}
		//return result;
	//}
	
	public static char lastIndexOf(String st, char a)
	{
		for(int i=0; i<= st.length(); i++)
		{
			
		}
	}
	
}
