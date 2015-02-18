// Player Class
// Program by : Nikhil Rathi


public class Player {
	// Attributes
	private String name;
	private Square currentSquare;
	public int spinNumber;
	int number = 0;
	int money;
	
	// Constructor: sets the name and currentSquare attributes to the parameters passed
	public Player(String s, Square sq){
		setName(s);
		setMoney(1000);
		setCurrentSquare(sq);
	}
	
	// This function will return the name
	public String getName(){
		return name;
	}
	
	// This function will set the name attribute
	public void setName(String nm){
		name = nm;
	}
	
	// This function will return the money
	public int getMoney(){
		return money;
	}
	
	// This function will set the money attribute
	public void setMoney(int x){
		money = x;
	}
	
	// The changeMoney method which will adjust the money of the player
	public void changeMoney(int num){
		money += num;
	}
	
	// This function will return the currentSquare
	public Square getCurrentSquare(){
		return currentSquare;
	}
	
	// This function will set the currentSquare attribute
	public void setCurrentSquare(Square square){
		currentSquare = new Square (square.getLabel());
	}
	
	// This method will spin and will forward the currentSquare and spinNumber to the move method of Board class
	public String takeTurn(Spinner sp, Board b){
		String playerTurns = "";
		spinNumber = sp.spin();
		number += spinNumber;
		playerTurns += spinNumber;
		currentSquare = b.move(currentSquare,  spinNumber);
		currentSquare.landOn(this);
		
		return playerTurns;
	}
	
	// The toString method will return a string
	public String toString(){
		return "Name " + name + "is at " + currentSquare.getLabel();
	}
}
