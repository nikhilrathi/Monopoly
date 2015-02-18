// Spinner class
// Program by : Nikhil Rathi

// To use the Random object, import the Random class
import java.util.Random;

public class Spinner {
	// Attributes
	public Random randomMaker;
	
	// Spin method which will return an integer from spinArray
	public int spin(){
		int [] spinArray = {1, 2, 3, 4, 5, -1, -2, -3};		// Array that holds the spin values
		randomMaker = new Random();							
		int x = randomMaker.nextInt(8);				// x holds a random integer between 0 and 8
		return spinArray[x];						// Return the xth element of spinArray
	}
}
