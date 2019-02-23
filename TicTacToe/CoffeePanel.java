package Bagel;

import javax.swing.*;
import java.awt.*;

/**
   The CoffeePanel class allows the user to select coffee.
*/

public class CoffeePanel extends JPanel
{
   // The following constants are used to indicate
   // the cost of coffee.
   public final double NO_COFFEE = 0.0;
   public final double REGULAR_COFFEE = 1.25;
   public final double DECAF_COFFEE = 1.25;
   public final double CAPPUCCINO = 2.00;
   public int p2win = 0;
   public int p2loss = 0;

   private JRadioButton noCoffee;      // To select no coffee
   private JRadioButton regularCoffee; // To select regular coffee
   private JRadioButton decafCoffee;   // To select decaf
   private JRadioButton cappuccino;    // To select cappuccino
   private ButtonGroup bg;             // Radio button group

   /**
      Constructor
   */

   public CoffeePanel()
   {
	// Create a GridLayout manager with 
	      // two rows and one column.
	      setLayout(new GridLayout(3, 1));

	      // Create the radio buttons.
	      JLabel winDisp = new JLabel("Wins:	" + Integer.toString(p2win));
	      JLabel lossDisp = new JLabel("Losses:	" + Integer.toString(p2loss));
	      JTextField n = new JTextField(10);
	      
	      //setSize(500,500);

	      // Add a border around the panel.
	      setBorder(BorderFactory.createTitledBorder("Player 2 (O):"));

	      // Add the radio buttons to the panel.
	      add(n, BorderLayout.EAST);
	      add(winDisp, BorderLayout.EAST);
	      add(lossDisp, BorderLayout.EAST);
   }

   /**
      getCoffeeCost method 
      @return The cost of the selected coffee.
   */

   public double getCoffeeCost()
   {
      double coffeeCost = 0.0;

      if (noCoffee.isSelected())
         coffeeCost = NO_COFFEE;
      else if (regularCoffee.isSelected())
         coffeeCost = REGULAR_COFFEE;
      else if (decafCoffee.isSelected())
         coffeeCost = DECAF_COFFEE;
      else if (cappuccino.isSelected())
         coffeeCost = CAPPUCCINO;

      return coffeeCost;
   }
}