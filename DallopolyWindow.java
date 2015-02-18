// DallopolyWindow class
// This class is responsible for the GUI
// Program by : Nikhil Rathi

// Importing required libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DallopolyWindow extends JFrame{
	
	// Buttons
	private JButton gamebtn;
	private JButton addPlayerbtn;
	private JButton playbtn;
	// Labels
	private JLabel playerName;
	// TextFIeld and Text Area
	private JTextField playerNameEnter;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	// Panels
	private JPanel northPanel;
	private JPanel northWestPanel;
	private JPanel northCenterPanel;
	private JPanel northEastPanel;
	private JPanel southPanel;
	private JPanel southWestPanel;
	private JPanel southEastPanel;
	private JPanel outerPanel;
	// Other Attributes
	private int counter = 0;
	private Dallopoly game = new Dallopoly();
	
	// Constructor
	public DallopolyWindow(){
		// Create an outerPanel
		outerPanel = new JPanel();
		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.Y_AXIS));
		outerPanel.setPreferredSize(new Dimension(550, 450));
//		outerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// Create a North Panel
		northPanel = new JPanel();
		northPanel.setMaximumSize(new Dimension(550, 50));
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
//		northPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// New Game Button and its ActionListner features
		gamebtn = new JButton("New Game");
		gamebtn.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	setGameString("NEW GAME!!!", true);
            	addPlayerbtn.setEnabled(true);
            }
        });  
		
		// The Player Name Label and the following TextField
		playerName = new JLabel("Player Name: ");
		playerNameEnter = new JTextField (20);
		playerNameEnter.setMaximumSize(new Dimension(350, 25));
		
		// Add Player Button and its ActionListner features
		addPlayerbtn = new JButton("Add Player");
		addPlayerbtn.setEnabled(false);
		addPlayerbtn.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	String name = playerNameEnter.getText().trim();
            	String displayName = "\nAdded Player: " + name;
            	
            	counter++;	// Update the counter and if counter is more than one enable play button
            	if (counter > 1){
            		playbtn.setEnabled(true);
            	}
            	if(name.length() != 0) {
            		setGameString(displayName, false);
            		game.addPlayer(name);
            		playerNameEnter.setText("");
            		
            	}
            }
        });  
		
		// Dividing the North Panel in East West and Center panels then adding respective features to them
		northWestPanel = new JPanel();
//		northWestPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		northWestPanel.add(gamebtn); // Add game button to northwestpanel
		
		northCenterPanel = new JPanel();
//		northCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		northCenterPanel.setLayout(new BoxLayout(northCenterPanel, BoxLayout.X_AXIS));
		northCenterPanel.add(playerName);
		northCenterPanel.add(playerNameEnter); // Add Jlabel and JTextField to northcenterpanel
		
		northEastPanel = new JPanel();
//		northEastPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		northEastPanel.add(addPlayerbtn); // Add addPlayer button to northeastpanel
		
		// Add these panels to the north Panel
		northPanel.add(northWestPanel);
		northPanel.add(northCenterPanel);
		northPanel.add(northEastPanel);
				
		// Create the South Panel and in that SouthWest and SouthEast Panels
		southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
		textArea = new JTextArea(30, 40);
		textArea.setEditable(false);	// Set the textArea uneditable
		playbtn = new JButton("Play");
		playbtn.setEnabled(false);
		// Add the Scroll Pane
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		// SothEast Panel
		southEastPanel = new JPanel();
		southEastPanel.setLayout(new BoxLayout(southEastPanel, BoxLayout.X_AXIS));
//		southEastPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		southEastPanel.add(Box.createHorizontalGlue());
		southEastPanel.add(playbtn);
		southEastPanel.add(Box.createHorizontalGlue());
		
		// Play Button and its ActionListner features
		playbtn.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	String gameMsg;
            	addPlayerbtn.setEnabled(false);
            	playbtn.setEnabled(false);
            	gameMsg = game.playGame();
            	setGameString(gameMsg, false);
            }
        });  
		
		// SouthWest Panel
		southWestPanel = new JPanel();
		southWestPanel.setLayout(new BoxLayout(southWestPanel, BoxLayout.X_AXIS));
		southWestPanel.setMaximumSize(new Dimension(450, 400));
//		southWestPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		southWestPanel.add(Box.createHorizontalGlue());
		southWestPanel.add(scrollPane);
		southWestPanel.add(Box.createHorizontalGlue());
		
		// Add them to South Panel
		southPanel.add(southWestPanel);
		southPanel.add(southEastPanel);
		
		// Now add the south and north panels to the outer panels
		outerPanel.add(northPanel, BorderLayout.NORTH);
		outerPanel.add(southPanel, BorderLayout.SOUTH);
		
		// Finally add the outer Panel
		add(outerPanel);
		
	}

	// This method will just append String to the TextArea
	public void setGameString(String textFieldDisplay, boolean reset) {
		if(reset)
			textArea.setText("");
		textArea.append(textFieldDisplay);
		textArea.repaint();
	}
	
}
