/**
 * This class is a part of the "Bulls and Cows" game. 
 * "Bulls and Cows" is a very simple, text based game.  
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates the 
 * game board, creates game history, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 * 
 * @author Partner A: Cole Heiple freeza1, Partner B: Vallab Kb kbv
 * @Version 11/4/2018
 */
 
import java.util.ArrayList;

class Game {
    
    
    //instance variables
   private GameBoard board;
   private GameHistory history;
   private Parser parser;
    
    //constuctor
   public Game(String args)
   {
      if(args.length() == 0)
      {
         board = new GameBoard();
      }
      else
         board= new GameBoard(args);
      history = new GameHistory();
      parser = new Parser();
   }
    
   public void play()
   {
      printHelp();
      boolean finished = false;
      while (! finished)
      {
         if(history.getNumOfGuesses() == 10)
         {
            System.out.println("You have exceeded the maximum number of guesses.");
            System.out.println("The computer wins");
            finished = true;
         }
         Command command = parser.getCommand();
         finished = processCommand(command);
      }
        
   }
    
   private boolean processCommand(Command command)
   {
      ArrayList theList = new ArrayList<>(3);
      boolean quitGame = false;
        
      if(command.isUnknown())
      {
         System.out.println("I'm afraid I can't do that Dave.");
         return false;
      }
        
      String commandWord = command.getCommandWord();
      if(commandWord.equals("help"))
         printHelp();
      else if (commandWord.equals("quit"))
         quitGame = quit();
      else if (commandWord.equals("history"))
         history.getHistory();
      else if(CommandWords.isGuess(commandWord))
      {
         theList = board.compareGuess(commandWord);
         int temp = (int) (theList.get(1));
         if( temp == (board.getSecretCodeLength()))
      {       
         System.out.println("Congratulations!");
         System.out.println("You guessed the secret code!");
         System.out.println("It took you "+(history.getNumOfGuesses()+1)+" guesses");
         quitGame = true;
      }
      
      if( temp != board.getSecretCodeLength())
      {
         System.out.println("You Guessed:");
         System.out.println(temp+" Bulls");
         System.out.println((int)(theList.get(2))+" Cows");
      }
         history.setGuess(theList);
      }
      return quitGame;
      
   }
                                    
   private void printHelp()
   {
      System.out.println("Your command words are:");
      System.out.println(parser.showCommands());
   }
    
   private boolean quit()
   {
      System.out.println("You have quit the game");  
      return true; 
   }
     
   private void printGuess(ArrayList theList)
   {
   }

     
        
    
}










