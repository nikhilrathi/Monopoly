// Square class
// Program by  : Nikhil Rathi

public class Square {
	// Attributes
	private String label;
	
	// Constructor: Will initialize the String label
	public Square (String s){
		setLabel(s);
	}
	
	// This method will set the label attribute
	public void setLabel(String s){
		label = s;
	}
	
	// This method will return the label attribute
	public String getLabel(){
		return label;
	}
	
	// landOn method
	public void landOn(Player p){
		p.changeMoney(0);
	}
	
	// The toSting method will return the following string
	public String toString(){
		return "Sqaure is at label: " + getLabel();
	}
}
