// Dallopoly Class
// Program by : Nikhil Rathi

// ArrayList class needed to support ArrayList functionalities
import java.util.ArrayList;

// Dallopoly class
public class Dallopoly {
	// Attributes
	private Board theBoard;
	private ArrayList<Player> players;
	private Spinner theSpinner;
	
	// Constructor: It will create a Spinner object, Board object, and ArrayList of Player object
	public Dallopoly(){
		theSpinner = new Spinner();
		try {
			theBoard = new Board();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(String name) {
		players.add(new Player(name, theBoard.getStartSquare()));
	}
	
	// Play Game method
	public String playGame(){
		boolean gameOver = false;		// Set a boolean to false
		Square cs;						// To refer to the returned square from players class
		
		String gameMessage = "\n\n";
		String playerMoves = "";
		
		// While gameOver is false continue the while loop
		while (gameOver == false){
			
			// First player takes turn and moves according to the spin
			playerMoves = players.get(0).takeTurn(theSpinner, theBoard);
			cs = players.get(0).getCurrentSquare();
			
			// Display where the player 1 moved and what was spun
			gameMessage += players.get(0).getName() + " spun "+ playerMoves + "\n" + players.get(0).getName() + " is on " + cs.getLabel() + "\n\n";
			//System.out.println(players.get(0).getName() + " spun "+ players.get(0).spinNumber + " " + players.get(0).getName() + " is on " + cs.getLabel());
			
			// If the player 1 is at the last square then display he won and break from the while loop
			if (cs == theBoard.getLastSquare()){
				gameOver = true;
				gameMessage += "GAME OVER!!! " + players.get(0).getName() + " is on SMU SQUARE" + "\n";
				//System.out.println("GAME OVER!!! " + players.get(0).getName() + " is on SMU SQUARE");
				break;
			}
			
			// If player 1 did not win then player 2 takes turn and moves according to spin
			else{
				playerMoves = players.get(1).takeTurn(theSpinner,  theBoard);
				cs = players.get(1).getCurrentSquare();
				
				// Display where the player 2 moved and what was spun
				gameMessage += players.get(1).getName() + " spun "+ playerMoves + "\n" + players.get(1).getName() + " is on " + cs.getLabel() + "\n\n";
				//System.out.println(players.get(1).getName() + " spun "+ players.get(1).spinNumber + " " + players.get(1).getName() + " is on " + cs.getLabel());
				
				// If player 2 is on last square then display he won and break from while loop
				if (cs == theBoard.getLastSquare()){
					gameOver = true;
					gameMessage += "GAME OVER!!! " + players.get(1).getName() + " is on SMU SQUARE" + "\n";
					//System.out.println("GAME OVER!!! " + players.get(1).getName() + " is on SMU SQUARE");
				}
			}
			
		}
		
		if (players.get(0).getMoney() > players.get(1).getMoney()){
			gameMessage += "Winner is: " + players.get(0).getName() + " with $" + players.get(0).getMoney() + "\n\n";
			//System.out.println("Winner is: " + players.get(0).getName() + " with $" + players.get(0).getMoney());
		}
		else if (players.get(0).getMoney() < players.get(1).getMoney()){
			gameMessage += "Winner is: " + players.get(1).getName() + " with $" + players.get(1).getMoney() + "\n";
			//System.out.println("Winner is: " + players.get(1).getName() + " with $" + players.get(1).getMoney());
		}
		else {
			gameMessage += "Game Tied!!";
			//System.out.println("Game Tied!!");
		}
		
		return gameMessage;
	}
	
}
