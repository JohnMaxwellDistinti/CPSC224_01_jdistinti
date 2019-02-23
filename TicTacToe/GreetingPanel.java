package Bagel;

import javax.swing.*;

/**
   The GreetingPanel class displays a greeting in a panel.
*/

public class GreetingPanel extends JPanel
{
   private JLabel nameDisp; // To display a greeting

   /**
      Constructor
   */

   public GreetingPanel()
   {
      // Create the label.
      nameDisp = new JLabel("Alice's turn");

      // Add the label to this panel.
      add(nameDisp);
   }
}