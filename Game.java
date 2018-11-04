// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

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










