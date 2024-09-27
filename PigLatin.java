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
        if (FigureOutWord.isVowel(s.substring(0, 1))){
            return true;
        }
        else{
            return false;
        }
    }
	public static boolean startsConsonant(String s){
        if (!FigureOutWord.isVowel(s.substring(0, 1))){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isVowel(String s){
        s = s.toUpperCase();
        String vowels = "AEIOU";
        if (vowels.contains(s)){
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
	public static int numberOfStartingConsonants(String s){
        int counter = 0;
        int num = 0;
        int num1 = 1;
        while (!FigureOutWord.isVowel(s.substring(num, num1))){
            counter += 1;
            num += 1;
            num1 += 1;
        }
        return counter;
    }
	/*public static String convertWord(String s)
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
	}  */
	public static String convertWord(String s)
    {
        if (FigureOutWord.numberOfStartingConsonants(s) == 0){
            return s + "way";
        }
        else{
            return s.substring(FigureOutWord.numberOfStartingConsonants(s)) + s.substring(0,FigureOutWord.numberOfStartingConsonants(s)) + "ay"; 
        }
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
		endingStr += FigureOutWord.convertWord(s.substring(num));
		return (endingStr);
	}  
   
}