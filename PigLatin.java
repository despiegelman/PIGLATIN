// Main.java			
// Pig Latin Converter
// This is the student starting file for Lab02bPigLatin.

import java.util.*;

public class PigLatin
{
	public static void main (String[] args)
	{
      	Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = input.nextLine();
        System.out.print(FigureOutWord.isVowel(str));	 	
		String piggie = FigureOutWord.convertWord(str);
		System.out.println();
		System.out.println("Converted word: " + piggie);
	}
}

///// This can be put all in one file or make a separate class in BlueJ
class FigureOutWord
{
	/*
	 * Precondition:  s is a String containing a single word.
	 * Postcondition: returns a word converted into Pig Latin according to the appropriate rule.
 	 * 
	 */
    public static boolean isVowel(String s){
        s = s.toUpperCase();
        if (s.substring(0, 1).equals("A") || s.substring(0, 1).equals("E") || s.substring(0, 1).equals("I") || s.substring(0, 1).equals("O") || s.substring(0, 1).equals("U")){
            return true;
        }
        else{
            return false;
        }
    }
	public static String convertWord(String s)
	{
     		 return "";      // This statement is provided to allow initial compiling.
	}  
   
}