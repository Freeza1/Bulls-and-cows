/**
 * This class is part of the "Bulls and Cows" game. 
 *"Bulls and Cows" is a very simple, text based game.  
 * 
 * This class holds information about a command that was issued by the user.
 * @author Partner A: Cole Heiple freeza1, Partner B: Vallab Kb kbv
 * @Version 11/4/2018
 */

public class Command
{
    private String commandWord;
    
    public Command(String command)
    {
        commandWord = command;
    }
    
    public String getCommandWord()
    {
        return commandWord;
    }
    
    public boolean isUnknown()
    {
        return (commandWord == null);
    }
    
    
}