// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock
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
            word1 = tokenizer.nextToken();     
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


