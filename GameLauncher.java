import java.awt.Dimension;

import javax.swing.JFrame;

// Dallopoly Game
// Program by : Nikhil Rathi

// This class will hold the main function.
public class GameLauncher {
	public static void main(String [] args){
	
		DallopolyWindow window = new DallopolyWindow();
		window.setSize(new Dimension(550, 450));
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Dallopoly");
	}
}
