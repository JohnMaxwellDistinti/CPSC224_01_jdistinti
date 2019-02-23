package Bagel;

import javax.swing.*;
import java.awt.*;

/**
   The CoffeePanel class allows the user to select coffee.
*/

public class DisplayTurn extends JPanel
{
   // The following constants are used to indicate
   // the cost of coffee.
   public String playerName = "Alice";

   /**
      Constructor
   */

   public DisplayTurn()
   {
	      JLabel name = new JLabel(playerName + "'s turn.");

	      setBorder(BorderFactory.createTitledBorder(""));

	      // Add the radio buttons to the panel.
	      add(name, BorderLayout.WEST);
   }

}