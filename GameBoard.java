/**
 * This class is a part of the "Bulls and Cows" game. 
 * "Bulls and Cows" is a very simple, text based game.
 *  
 * This class is the workhorse class of the "Bulls and Cows" game.
 * This class creates the gameboard and generates the secret code that
 * is to be guessed by the user. It also compares the users guess with the
 * secret code and displays the number of bulls and cows of each guess.
 * @author Partner A: Cole Heiple freeza1, Partner B: Vallab Kb kbv
 * @Version 11/4/2018
 */
 
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;

public class GameBoard
{
   //instance variables
   private ArrayList<String> secretCode;
   private static String alphabet;
   private int numOfLetters;
   private int numOfSpaces;
       
   //constructor
   public GameBoard(int letters, int spaces)
   {
      
      secretCode = new ArrayList<String>();
      
      alphabet = createAlphabet(numOfLetters);
      numOfLetters = letters;
      numOfSpaces = spaces;
      
      
      /* 
          * For each place in the arraylist secretCode, generates a random number and
          * takes the letter in that place in alphabet and places that into the secret code
      */
      Random rand = new Random();
      
      
      for (int x = 0; x<numOfSpaces; x++)
      {
         int value = rand.nextInt(numOfLetters);
         char c = alphabet.charAt(value);
         secretCode.add(Character.toString(c));
      }
   
   }
   // Creates the arraylist secretcode from a predetermined string
   public GameBoard(String codeWord)
   {
      codeWord = codeWord.toLowerCase();
      alphabet = "";
      for(int x=0;x<codeWord.length();x++)
      {
         if(!alphabet.contains(Character.toString(codeWord.charAt(x))))
            alphabet+=Character.toString(codeWord.charAt(x));
      }
      numOfLetters = codeWord.length();
      numOfSpaces = codeWord.length();
      secretCode = new ArrayList<String>();
      for (int x=0; x<codeWord.length(); x++)
      {
         secretCode.add(Character.toString(codeWord.charAt(x)));
      }
      
   }
   
   public GameBoard()
   {
      alphabet = createAlphabet(5);
      
      numOfLetters = 5;
      numOfSpaces = 5;
      
      secretCode = new ArrayList<String>();
      
      Random rand = new Random();
      
      
      for (int x = 0; x<5; x++)
      {
         int value = rand.nextInt(5);
         char c = alphabet.charAt(value);
         secretCode.add(Character.toString(c));
      }
   }
   
   public String createAlphabet(int numOfLetters)
   {
      alphabet = "";
      for(int x=0; x<numOfLetters; x++)
      {
         char tempChar = (char)(97+x);
         String s = "" + tempChar;
         alphabet = alphabet.concat(s);
      }
   
      return alphabet;
   }
   
   public static String getAlphabet()
   {
      return alphabet;
   }
   
   public int getNumOfLetters()
   {
      return numOfLetters;
   }
   
   public int getNumOfSpaces()
   {
      return numOfSpaces;
   }
   
   public int getSecretCodeLength()
   {
      return secretCode.size();
   }
   // methods
   
   // compares the guessed string to the secret code
   public ArrayList compareGuess(String guess)
   {
      
      int bulls = 0;
      int cows = 0;
      ArrayList<String> tempSecretCode = new ArrayList<>();
      ArrayList<String> guessedCode = new ArrayList<String>();
      
      for (int x=0;x<secretCode.size();x++)
      {
         tempSecretCode.add(secretCode.get(x));
      }
      
      for (int x=0; x<guess.length(); x++)
      {
         guessedCode.add(Character.toString(guess.charAt(x)));
         
      }
      
      // Actually compares the guessed code to the secret code
      
      // first for loop checks for and removes all bulls from the secret code
      for (int x=0; x<guessedCode.size(); x++)
      {
         String temp = guessedCode.get(x);
         
         if (tempSecretCode.get(x).equals(temp))
         {
            tempSecretCode.set(x, "done");
            guessedCode.set(x, "correct");
            bulls++;
         }
         
         
         
         
      }
      
      // second for loop takes the remaining secret code and checks to see if any 
      // cows remain from the secret code that is left
      if(bulls != getSecretCodeLength())
      {
         for (int x = 0; x<guessedCode.size(); x++)
         {
            String temp = guessedCode.get(x);
            if (tempSecretCode.contains(temp))
            {
               tempSecretCode.remove(tempSecretCode.indexOf(guessedCode.get(x)));
               guessedCode.set(x, "correct");
               cows++;
            }
         }
      }
            
      ArrayList theList = new ArrayList<>(3);
      theList.add(guess);
      theList.add(bulls);
      theList.add(cows);
      return theList;
      //history.setGuess(guess, bulls, cows);
       
   }
   
}












