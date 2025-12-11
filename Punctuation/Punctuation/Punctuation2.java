//Sanvitti Shah
//Per. 2
//Punctuation.java
/*
*Pseudocode:
*Write header
*Main
*	make instance of class and use it to call search it
*searchIt(String str)
*	call getPunctution and printWords
*	return str
*getPunctuationWords
*	
* 
* 
*/
 
public class Punctuation2
{
	public static void main(String [] args)
	{
		String text = new String("Hello's. \"hey,how are you?\" HEY!");
		Punctuation2 punc = new Punctuation2();
		punc.searchIt(text);
	}
	public String searchIt(String str)
	{
		getPunctuationWords(str);
		printWords(str);
		return str;
	}
	public String getPunctuationWords(String strIn1)
	{
		return checkForPunctuation(strIn1);
	}
	public boolean checkForPunctuation(String strIn2)
	{
		for(int i = 0; i<=(strIn2.length())-1; i++)
		 {
			if(
		 }
		
	}
	public void printWords(String strIn3)
	{
		System.out.println(strIn3);
	}	 
}
