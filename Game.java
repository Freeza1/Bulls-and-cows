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

class Game {
    
    
    //instance variables
    private GameBoard board;
    private GameHistory history;
    private Parser parser;
    
    //constuctor
    public Game()
    {
        board = new GameBoard();
        history = new GameHistory();
        parser = new Parser();
    }
    //methods 
    public void play()
    {
        boolean finished = false;
        while (! finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
    }
    
    private boolean processCommand(Command command)
    {
        boolean quitGame = false;
        
        if(command.isUnknown())
        {
            System.out.println("I'm afraid I can't do that Dave.");
            return false;
        }
        
        String commandWord = command.getCommandWord();
        if(commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("start"))
            play();
        else if (commandWord.equals("quit"))
            quitGame = quit();
        else if (commandWord.equals("history"))
            history.getHistory();
        else if(CommandWords.isGuess(commandWord))
            board.compareGuess(commandWord);
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

     
        
    
}










