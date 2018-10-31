// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

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