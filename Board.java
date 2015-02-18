// Board Class
// Program by : Nikhil Rathi

// ArrayList class needed to support ArrayList functionalities
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

// Board class
public class Board {
	// Attributes
	private ArrayList<Square> squares=new ArrayList<Square>();
	
	
	// Constructor: will create an ArrayList of Squares and will initialize
	public Board() throws Exception{
		
		//delimeter (" ,| \n");
		
		BufferedReader reader= new BufferedReader(new FileReader("squareList.txt"));
		String line = null;
		//ArrayList list=new ArrayList();
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",|\n");
		//	for (String part : parts) {
			    switch(parts[0]){
			    	case "Square": squares.add(new Square(parts[1]));
			    					break;
			    	case "PenaltySquare": squares.add(new PenaltySquare(parts[1]));
											break;
			    	case "PrizeSquare": squares.add(new PrizeSquare(parts[1]));
										break;
			    	case "LastSquare": squares.add(new LastSquare(parts[1]));
									break;
			 //   }
			}
		}
		/*squares = new ArrayList<Square>(17);
		squares.add(new Square("Reunion Tower"));
		squares.add(new Square("Dealey Plaza"));
		squares.add(new Square("Design District"));
		squares.add(new Square("Victory Park"));
		squares.add(new Square("West End"));
		squares.add(new Square("Perot Museum"));
		squares.add(new Square("Downtown"));
		squares.add(new Square("Klyde Warren Park"));
		squares.add(new Square("Arts District"));
		squares.add(new Square("Deep Ellum"));
		squares.add(new Square("Fair Park"));
		squares.add(new Square("West Village"));
		squares.add(new Square("Katy Trail"));
		squares.add(new Square("North Park Mall"));
		squares.add(new Square("White Rock Lake"));
		squares.add(new Square("Bush Library"));
		squares.add(new Square("SMU"));*/
	}
	
	// This method will return square at zeroth element of ArrayList
	public Square getStartSquare(){
		return squares.get(0);
	}
	
	// This method will return square at last element of ArrayList
	public Square getLastSquare(){
		return squares.get(squares.size()-1);
	}
	
	// The move method will move the current sqaure
	public Square move (Square sq, int num){
		
		int counter = 0;		// Counter variable
		
		// While you dont find that element, increment the counter variable
		while (squares.get(counter).getLabel() != sq.getLabel()) {
				if (squares.get(counter).getLabel() == sq.getLabel())
					break;
		counter++;
		}

		int counter2 = num + counter;	// Add the counter variable to counter2 variable
		
		// If counter2 is less than 0 or greater than 16 then return the same square passed
		if (counter2 > 16 || counter2 < 0){
			return squares.get(counter);
		}
		// If not then return the square at counter2
		else {
			return squares.get(counter2);
		}

	}
}
