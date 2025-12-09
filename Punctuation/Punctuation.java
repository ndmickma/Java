//Sanvitti Shah
//Per. 2
//Punctuation.java
/*
 * 
 * 
 */
 
 public class Punctuation
 {
	 public static void main(String [] args)
	 {
		 String text = new String("Hello. hey,how are you? HEY!");
		 Punctuation punc = new Punctuation();
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
	 public String checkForPunctuation(String strIn2)
	 {
		 for(int i = 0; i<=(strIn2.length())-1; i++)
		 {
			 if(strIn2.charAt(i) == '?' || strIn2.charAt(i) == '!' || strIn2.charAt(i) == ':' || strIn2.charAt(i) == '\"' || strIn2.charAt(i)== '\'' || strIn2.charAt(i) == '.' || strIn2.charAt(i)== ';')
			 {
				 strIn2.substring(strIn2.lastIndexOf(" ", i )+1, i+1); //THE LAST INDEX THING IS WRONG :(
			 } 
		 }
		 return strIn2;
	 }
	 public void printWords(String strIn3)
	 {
		 System.out.println(strIn3);
	 }
	
	 
 }
