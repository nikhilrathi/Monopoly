
public class PrizeSquare extends Square {
	// Attributes:
	String label;
	
	// Constructor:
	public PrizeSquare(String s){
		super(s);
	}
	
	public void landOn(Player p){
		p.changeMoney(100);
	}
	
}
