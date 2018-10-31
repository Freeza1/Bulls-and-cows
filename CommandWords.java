// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

public class CommandWords
{
    private static final String[] validCommands = {"start","quit","history","help"};
    //private static final String[] alphabet = {"abcde"}
    private String alphabet;
    private GameBoard board;
    
    public CommandWords()
    {
        board = new GameBoard(board.getNumOfLetters(), board.getNumOfSpaces());
        alphabet = board.getAlphabet();
            
    }
   
    
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
    
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

}