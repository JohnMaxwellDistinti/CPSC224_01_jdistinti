// package Bagel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGame extends JFrame {
   private StatPanel stats;     // Bagel panel
   private ButtonPanel tictactoe;
   private DisplayTurn displayName;
   private JPanel buttonPanel;    // To hold the buttons
   private JButton calcButton;    // To calculate the cost
   private JButton exitButton;    // To exit the application
   private final int WINDOW_WIDTH = 500;  // Window width
   private final int WINDOW_HEIGHT = 500; // Window height

   public TicTacToeGame() {
      // Display a title.
      setTitle("Tic Tac Toe");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());
      // Create the custom panels.
      stats = new StatPanel();
      displayName = new DisplayTurn();
      tictactoe = new ButtonPanel();

      // Create the button panel.
      buildButtonPanel();

      // Add the components to the content pane.
      add(stats, BorderLayout.NORTH);
      add(tictactoe, BorderLayout.CENTER);
      add(displayName, BorderLayout.SOUTH);

      // Pack the contents of the window and display it.
      pack();
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setVisible(true);
   }

   private void buildButtonPanel() {
      // Create a panel for the buttons.
      buttonPanel = new JPanel();

      // Create the buttons.
      calcButton = new JButton("Calculate");
      exitButton = new JButton("Exit");

      // Register the action listeners.
      exitButton.addActionListener(new ExitButtonListener());

      // Add the buttons to the button panel.
      buttonPanel.add(calcButton);
      buttonPanel.add(exitButton);
   }

   private class ExitButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
          System.exit(0);
      }
   }
   public static void main(String[] args) {
      new TicTacToeGame();
   }
}