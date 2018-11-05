                                                        Bulls and Cows – A simple Text Based Game

Bulls and Cows:  This class initializes the game and runs all the classes.

Command:  This class holds the information about the commands that are issued by the user.

Command Words:  This class holds a list of all the valid command words that can be used by the 
user. It also checks to see whether the command word entered by the user is a valid command. It 
also checks whether the letters in the guess made by the user is in the predetermined string of 
alphabets. 

Game:  This class creates and initializes the GameBoard, GameHistory and the Parser classes. It 
also evaluates and executes the commands that are returned by the Parser class. It also keeps 
count of the number of guesses made by the user and if it exceeds ten guesses then it quits the 
game and prints out a message that says, “The computer has won the Game”.

Game Board:  This is the main class of the “Bulls and Cows” game. It creates the game board 
and randomly generates the secret code from a pre-determined string of alphabets. It also 
compares the guesses made by the user and compares it with the secret code and prints out the 
number of Bull and Cows of each guess. 

Game History:  This class stores all the previous guesses made by the user and the number of 
guesses made. It also prints out the previous guesses and the Bulls and Cows of each guess when 
it is requested by the user. 

Parser: The parser reads the user input and tries to interpret it as a command. Every time the user 
inputs something, it reads it and returns the command as an object of the class Command. 

