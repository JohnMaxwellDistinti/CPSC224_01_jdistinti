// package Bagel;

import javax.swing.*;
import java.awt.*;

public class StatPanel extends JPanel {
   private PlayerPanel p1Panel;
   private PlayerPanel p2Panel;

   public StatPanel() {
      // Create a GridLayout manager with 
      // two rows and one column.
      setLayout(new GridLayout(1, 1));
      p1Panel = new PlayerPanel();
      p2Panel = new PlayerPanel();
      add(p1Panel, BorderLayout.WEST);
      add(p2Panel, BorderLayout.EAST);
   }
}