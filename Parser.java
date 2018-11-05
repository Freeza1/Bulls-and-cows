/*
 * This class is part of the "Bulls and Cows" game. 
 * "Bulls and Cows" is a very simple, text based game.  
 * 
 * This parser reads user input and tries to interpret it as an "Game"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author Partner A: Cole Heiple freeza1, Partner B: Vallab Kb kbv
 * @Version 11/4/2018
 */
 
 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parser
{
  private CommandWords commands; 
    
  public Parser() 
  {
      
      commands = new CommandWords();
  }

    public Command getCommand() 
    {
        String inputLine = "";  
        String word1;

        System.out.print("> ");     

        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                                + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken().toLowerCase();     
        else
            word1 = null;
        if(commands.isCommand(word1) || commands.isGuess(word1))
            return new Command(word1);
        else
            return new Command(null);
        
    }
    
    public String showCommands()
    {
      return commands.showAll();
    }
}


