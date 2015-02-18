
public class PenaltySquare extends Square{
	
	public PenaltySquare(String s){
		super(s);
	}
	
	public void landOn(Player p){
		p.changeMoney(-200);
	}
	
}
