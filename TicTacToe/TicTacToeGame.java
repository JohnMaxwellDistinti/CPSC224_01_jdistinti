// package Bagel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGame extends JFrame {
   private StatPanel stats;     // Bagel panel
   private ButtonPanel tictactoe;
   private DisplayTurn displayName;
   private final int WINDOW_WIDTH = 500;  // Window width
   private final int WINDOW_HEIGHT = 500; // Window height

   public TicTacToeGame() {
      // Display a title.
      setTitle("Tic Tac Toes");
      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Create a BorderLayout manager.
      setLayout(new BorderLayout());
      // Create the custom panels.
      stats = new StatPanel();
      displayName = new DisplayTurn();
      tictactoe = new ButtonPanel();

      // Add the components to the content pane.
      add(stats, BorderLayout.NORTH);
      add(tictactoe, BorderLayout.CENTER);
      add(displayName, BorderLayout.SOUTH);

      // Pack the contents of the window and display it.
      pack();
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setVisible(true);
   }

   public static void main(String[] args) {
      new TicTacToeGame();
   }
}