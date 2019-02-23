package Bagel;

import javax.swing.*;
import java.awt.*;

/**
   The BagelPanel class allows the user to select either
   a white or whole wheat bagel.
*/

public class BagelPanel extends JPanel
{
   // The following constants are used to indicate
   // the cost of each type of bagel.
   public final double WHITE_BAGEL = 1.25;
   public final double WHEAT_BAGEL = 1.50;
   private Player1Panel p1Panel;
   private Player2Panel p2Panel;
   public int p1win = 0;
   public int p1loss = 0;
   public int p2win = 0;
   public int p2loss = 0;

   private JRadioButton whiteBagel;  // To select white
   private JRadioButton wheatBagel;  // To select wheat
   private ButtonGroup bg;           // Radio button group

   /**
      Constructor
   */

   public BagelPanel()
   {
      // Create a GridLayout manager with 
      // two rows and one column.
      setLayout(new GridLayout(1, 1));

      // Create the radio buttons.
      p1Panel = new Player1Panel();
      p2Panel = new Player2Panel();
      
      add(p1Panel, BorderLayout.WEST);
      add(p2Panel, BorderLayout.EAST);

      /*// Create the radio buttons.
      JLabel winDisp2 = new JLabel("Wins:	" + Integer.toString(p2win));
      JLabel lossDisp2 = new JLabel("Losses:	" + Integer.toString(p2loss));
      JTextField k = new JTextField(10);

      // Add a border around the panel.
      setBorder(BorderFactory.createTitledBorder("Player 2 (O):"));

      // Add the radio buttons to the panel.
      add(k, BorderLayout.EAST);
      add(winDisp2, BorderLayout.EAST);
      add(lossDisp2, BorderLayout.EAST);*/
   }

   /**
      getBagelCost method
      @return The cost of the selected bagel.
   */

   public double getBagelCost()
   {
      double bagelCost = 0.0;
      return bagelCost;
   }
}