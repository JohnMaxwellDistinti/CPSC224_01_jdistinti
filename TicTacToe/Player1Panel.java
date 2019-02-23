package Bagel;

import javax.swing.*;
import java.awt.*;

/**
   The BagelPanel class allows the user to select either
   a white or whole wheat bagel.
*/

public class Player1Panel extends JPanel
{
   // The following constants are used to indicate
   // the cost of each type of bagel.
   public final double WHITE_BAGEL = 1.25;
   public final double WHEAT_BAGEL = 1.50;
   private CoffeePanel coffee;
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

   public Player1Panel()
   {
      // Create a GridLayout manager with 
      // two rows and one column.
      setLayout(new GridLayout(3, 1));

      // Create the radio buttons.
      JLabel winDisp = new JLabel("Wins:	" + Integer.toString(p1win));
      JLabel lossDisp = new JLabel("Losses:	" + Integer.toString(p1loss));
      JTextField n = new JTextField(10);

      // Add a border around the panel.
      setBorder(BorderFactory.createTitledBorder("Player 1 (X):"));

      // Add the radio buttons to the panel.
      add(n, BorderLayout.WEST);
      add(winDisp, BorderLayout.WEST);
      add(lossDisp, BorderLayout.WEST);
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