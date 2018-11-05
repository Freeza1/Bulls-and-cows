/**
 * This class is part of the "Bulls and Cows" game. 
 * "Bulls and Cows" is a very simple, text based game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 * @author Partner A: Cole Heiple freeza1, Partner B: Vallab Kb kbv
 * @Version 11/4/2018
 */


public class CommandWords
{
   // instance variables
   private static final String[] validCommands = {"start","quit","history","help"};
   //private static final String[] alphabet = {"abcde"}
   private static String alphabet;
   
   // constructor
   public CommandWords()
   {
      alphabet = GameBoard.getAlphabet();
          
   }
  
   // methods
   public boolean isValid(String aString)
   {
      for(int x = 0; x < validCommands.length; x++)
      {
         if(validCommands[x].equals(aString))
            return true;
      }
      boolean guessTrue = true;
      while( guessTrue != false)
      {
         for(int x=0; x<alphabet.length(); x++)
         {
            if(alphabet.contains(Character.toString(aString.charAt(x))))
               guessTrue = true;
            else
            {
               System.out.println("Guessed code must only contain the letters " +alphabet);
               guessTrue = false;   
            }
         }
      }
      return false;
   }
                  
   public String[] getCommandWords()
   {
      return validCommands;
   }
   
   public String showAll()
   {
      String commandList = "   ";
      for(int x=0; x < validCommands.length; x++)
      {
         commandList += validCommands[x] + " ";
      }
      return commandList;
   }
    
    public static boolean isGuess(String guess)
    {
      boolean isTrue = true;
      for (int x=0; x<alphabet.length();x++)
      {
         if(alphabet.contains(guess))
            isTrue = true;
         else
            return false;
         
      }
        return true;
    }
   
   public boolean isCommand(String aString)
   {
      for(int i = 0; i < validCommands.length; i++) {
         if(validCommands[i].equals(aString))
            return true;
      }
      // if we get here, the string was not found in the commands or the guess was not in the alphabet
      return false;
   }

}