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
		input.close();
		if (str.indexOf(" ") == -1){
			String piggie = FigureOutWord.convertWord(str);
			System.out.println("Converted word: " + piggie);
		}
		else{
			String piggie = FigureOutWord.convertSentence(str);
			System.out.println("Converted sentence: " + piggie);
		}
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
	public static boolean startsVowel(String s){
        s = s.toUpperCase();
        if (s.substring(0, 1).equals("A") || s.substring(0, 1).equals("E") || s.substring(0, 1).equals("I") || s.substring(0, 1).equals("O") || s.substring(0, 1).equals("U")){
            return true;
        }
        else{
            return false;
        }
    }
	public static boolean startsConsonant(String s){
        s = s.toUpperCase();
        if (s.substring(0, 1).equals("A") || s.substring(0, 1).equals("E") || s.substring(0, 1).equals("I") || s.substring(0, 1).equals("O") || s.substring(0, 1).equals("U")){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean isVowel(String s){
        s = s.toUpperCase();
        if (s.equals("A") || s.equals("E") || s.equals("I") || s.equals("O") || s.equals("U")){
            return true;
        }
        else{
            return false;
        }
    }
	public static boolean startsTwoConsonants(String s){
		s.toUpperCase();
		if (FigureOutWord.startsConsonant(s)){
			if (FigureOutWord.isVowel(s.substring(1,2))){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			return false;
		}
	}
	public static String convertWord(String s)
	{
		if (FigureOutWord.startsConsonant(s) && FigureOutWord.startsTwoConsonants(s)){
			return s.substring(2) + s.substring(0,2) + "ay";
		}
		else if (FigureOutWord.startsConsonant(s)){
			return s.substring(1) + s.substring(0,1) + "ay";
		}
		else if (FigureOutWord.startsVowel(s)){
			return s + "way";
		}
     		 return "";      // This statement is provided to allow initial compiling.
	}  
	public static String convertSentence(String s)
	{
		int num = 0;
		int num1 = s.indexOf(" ");
		String endingStr = "";
		while (num1 > -1){
			endingStr += FigureOutWord.convertWord(s.substring(num, num1)) + " ";
			num = num1+1;
			num1 = s.indexOf(" ", num);
		}
		endingStr += FigureOutWord.convertWord(s.substring(num, s.length()-1));
		return (endingStr);
	}  
   
}