// package Bagel;

import javax.swing.*;
import java.awt.*;

public class StatPanel extends JPanel {
   public PlayerPanel p1Panel;
   public PlayerPanel p2Panel;

   public StatPanel() {
      // Create a GridLayout manager with 
      // two rows and one column.
      setLayout(new GridLayout(1, 1));
      p1Panel = new PlayerPanel(1, 'X');
      p2Panel = new PlayerPanel(2, 'O');
      add(p1Panel, BorderLayout.WEST);
      add(p2Panel, BorderLayout.EAST);
   }
}