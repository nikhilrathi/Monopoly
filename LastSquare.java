
public class LastSquare extends Square {
	
	public LastSquare(String s){
		super(s);
	}
	
	public void landOn(Player p){
		p.changeMoney(300);
	}
}
