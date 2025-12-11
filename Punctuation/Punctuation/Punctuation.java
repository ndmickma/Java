//Sanvitti Shah
//Per. 2
//Punctuation.java
/*
 * Pseudocode:
 * Write header
 * Main
 * 	make instance of class and use it to call search it
 * searchIt(String str)
 * 	call getPunctution and printWords
 * 	return str
 * getPunctuationWords
 * 	
 * 
 * 
 */
 
 public class Punctuation
 {
	 public static void main(String [] args)
	 {
		 String text = new String("Hello's. \"hey,how are you?\" HEY!");
		 Punctuation punc = new Punctuation();
		 punc.searchIt(text);
	 }
	 public String searchIt(String str)
	 {
		 String abc = getPunctuationWords(str);;
		 printWords(abc);
	 }
	 public String getPunctuationWords(String strIn1)
	 {
		 String b = " ";
		 String c = "";
		 for(int j = 0; j<= strIn1.length(); j++)
		 {
			 char d = strIn1.charAt(j);
			 if(d!= ' ')
			 {
				 b+=d;
			 }
			 else
			 {
				 if(checkForPunctuation(strIn1)
				 {
					 b+=(strIn1+"\n")
				 }
				 strIn1 = " ";
			 } 
		 }
		 return b;
	 }
	 public String checkForPunctuation(String strIn2)
	 {
		 int counter = 0;
		 for(int i = 0; i<=(strIn2.length())-1; i++)
		 {
			 counter++;
			 if(strIn2.charAt(i) == '?' || strIn2.charAt(i) == '!' || strIn2.charAt(i) == ':' || strIn2.charAt(i) == '\"' || strIn2.charAt(i)== '\'' || strIn2.charAt(i) == '.' || strIn2.charAt(i)== ';')
			 {
				 strIn2.substring(i-counter+1, i+1); 
				 counter=0;
			 } 
		 }
		 return strIn2;
	 }
	 public void printWords(String strIn3)
	 {
		 System.out.println(strIn3);
	 }
	
	 
 }
