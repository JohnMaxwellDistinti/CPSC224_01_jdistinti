// package Bagel;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
   public int wins = 0;
   public int losses = 0;

   public PlayerPanel() {
	   setLayout(new GridLayout(3, 1));
	   JLabel winDisp = new JLabel("Wins:	" + Integer.toString(wins));
	   JLabel lossDisp = new JLabel("Losses:	" + Integer.toString(losses));
	   JTextField n = new JTextField(10);
	   setBorder(BorderFactory.createTitledBorder("Player 2 (O):"));
	   add(n, BorderLayout.EAST);
	   add(winDisp, BorderLayout.EAST);
	   add(lossDisp, BorderLayout.EAST);
   }
}