import java.util.HashMap;
import java.util.ArrayList;

class GameHistory
{
    HashMap<String, ArrayList> previousGuesses;
    int numOfGuesses;
    
    //contructor
    public GameHistory()
    {
        previousGuesses = new HashMap<String, ArrayList>();
        numOfGuesses = 0;
    }
    
    public int getNumOfGuesses()
    {
        return numOfGuesses;
    }
    
    public void getHistory()
    {
        if(previousGuesses.isEmpty())
        {
            System.out.println("No guesses have been made yet!");
        }
        for(int x=0;x<previousGuesses.size();x++)
        {
             System.out.println(previousGuesses.get("Guess"+x));  
        }
    }
    
    // Takes the most recent guess, adds it to the hashmap and increments numOfGuesses
    public static void setGuess( String guessedString, int bulls, int cows)
    {
        ArrayList<String> guessInfo = new ArrayList<String>();
        guessInfo.add(guessedString);
        guessInfo.add("Bulls: "+bulls);
        guessInfo.add("Cows: "+cows);
        
        previousGuesses.put(("Guess"+numOfGuesses), guessInfo);
        numOfGuesses++;
    }
    
    
}
