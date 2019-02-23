package Bagel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   The OrderCalculatorGUI class creates the GUI for the
   Brandi's Bagel House application.
*/

public class OrderCalculatorGUI extends JFrame
{
   private BagelPanel bagels;     // Bagel panel
   private ToppingPanel toppings; // Topping panel
   private CoffeePanel coffee;    // Coffee panel
   private GreetingPanel banner;  // To display a greeting
   private ButtonPanel tictactoe;
   private DisplayTurn displayName;
   private ButtonPanel game;
   private JPanel buttonPanel;    // To hold the buttons
   private JButton calcButton;    // To calculate the cost
   private JButton exitButton;    // To exit the application
   private final double TAX_RATE = 0.06; // Sales tax rate
   private final int WINDOW_WIDTH = 500;  // Window width
   private final int WINDOW_HEIGHT = 500; // Window height

   /**
      Constructor
   */

   public OrderCalculatorGUI()
   {
      // Display a title.
      setTitle("Tic Tac Toe");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());
      

      // Create the custom panels.
      bagels = new BagelPanel();
      displayName = new DisplayTurn();
      tictactoe = new ButtonPanel();
      //toppings = new ToppingPanel();
      //coffee = new CoffeePanel();
      //game = new ButtonPanel();

      // Create the button panel.
      buildButtonPanel();

      // Add the components to the content pane.
      add(bagels, BorderLayout.NORTH);
      //add(coffee, BorderLayout.NORTH);
      //add(toppings, BorderLayout.CENTER);
      add(tictactoe, BorderLayout.CENTER);
      add(displayName, BorderLayout.SOUTH);

      // Pack the contents of the window and display it.
      
      pack();
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setVisible(true);
   }

   /**
      The buildButtonPanel method builds the button panel.
   */

   private void buildButtonPanel()
   {
      // Create a panel for the buttons.
      buttonPanel = new JPanel();

      // Create the buttons.
      calcButton = new JButton("Calculate");
      exitButton = new JButton("Exit");

      // Register the action listeners.
      calcButton.addActionListener(new CalcButtonListener());
      exitButton.addActionListener(new ExitButtonListener());

      // Add the buttons to the button panel.
      buttonPanel.add(calcButton);
      buttonPanel.add(exitButton);
   }

   /**
      Private inner class that handles the event when
      the user clicks the Calculate button.
   */

   private class CalcButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Variables to hold the subtotal, tax, and total
         double subtotal, tax, total;

         // Calculate the subtotal.
         subtotal = bagels.getBagelCost() + 
                    toppings.getToppingCost() +
                    coffee.getCoffeeCost();

         // Calculate the sales tax.
         tax = subtotal * TAX_RATE;

         // Calculate the total.
         total = subtotal + tax;

         // Display the charges.
         JOptionPane.showMessageDialog(null,
            String.format("Subtotal: $%,.2f\n" +
                          "Tax: $%,.2f\n" +
                          "Total: $%,.2f",
                          subtotal, tax, total));
      }
   }

   /**
      Private inner class that handles the event when
      the user clicks the Exit button.
   */

   private class ExitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
          System.exit(0);
      }
   }
   
   /**
      main method
   */
   
   public static void main(String[] args)
   {
      new OrderCalculatorGUI();
   }
}