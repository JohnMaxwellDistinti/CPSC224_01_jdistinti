// package Bagel;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
    public int wins;
    public int losses;
    public JLabel winDisplay;
    public JLabel lossDisplay;
    public JTextField nameField;
    public PlayerPanel(int playerNum, char playerMark) {
	    wins = 0;
	    losses = 0;
	    winDisplay = new JLabel("Wins:	" + Integer.toString(wins));
	    lossDisplay = new JLabel("Losses:	" + Integer.toString(losses));
	    setLayout(new GridLayout(3, 1));
	    nameField = new JTextField("Default", 8);
	    setBorder(BorderFactory.createTitledBorder("Player " + playerNum + " (" + playerMark + "):"));
	    add(nameField, BorderLayout.EAST);
	    add(winDisplay, BorderLayout.EAST);
	    add(lossDisplay, BorderLayout.EAST);
   }
}