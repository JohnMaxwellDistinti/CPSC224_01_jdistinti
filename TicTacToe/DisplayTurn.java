// package Bagel;

import javax.swing.*;
import java.awt.*;

public class DisplayTurn extends JPanel {
   public String playerName = "Alice";
   public DisplayTurn() {
	   JLabel name = new JLabel(playerName + "'s turn.");
	   setBorder(BorderFactory.createTitledBorder(""));
	   add(name, BorderLayout.WEST);
   }
}