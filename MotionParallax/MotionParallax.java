/***************
MotionParallax.java
Due Date: 3/23/19
Names: John Maxwell Distinti
********************/

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

/**
   This class demonstrates how to use an ImageIcon
   and a JLabel to display an image.
*/

public class MotionParallax extends JFrame
{
   private JPanel grassPanel;     // To hold the labeln
   private JPanel skyboxPanel;     // To hold the label
   private JLabel grassLabel;     // To show an image
   private JLabel skyLabel;     // To show an image
   private int WINDOW_WIDTH = 700;
   private int WINDOW_HEIGHT = 700;


   /**
      Constructor
   */

   public MotionParallax()
   {
      // Set the title.
      setTitle("Motion Parallax");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());

      // Build the panels.
      buildLandscapePanels();
      
      grassPanel = new JPanel();
      grassLabel = new JLabel("");

      // Add the panels to the content pane.
      add(grassPanel, BorderLayout.SOUTH);
      
      grassPanel.add(grassLabel);

      // Read the image file into an ImageIcon object.
      ImageIcon landscape = new ImageIcon("nicelandscape.png");
      
      // Display the image in the label.
      grassLabel.setIcon(landscape);
      grassLabel.setText(null);

      // Pack the frame again to accomodate the 
      // new size of the label.
      pack();
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setVisible(true);
   }

   /**
      The buildImagePanel method adds a label to a panel.
   */

   private void buildLandscapePanels()
   {
      /*// Create a panel.
      grassPanel = new JPanel();

      // Create a label.
      grassLabel = new JLabel("");
      
      // Add the label to the panel.
      grassPanel.add(grassLabel);
      //dicePanel1.add(imageLabel);
      
      ImageIcon firstDie = new ImageIcon("Die1.png");
      ImageIcon secondDie = new ImageIcon("Die2.png");
      .setIcon(firstDie);
      imageLabel0.setText(null);
      imageLabel1.setIcon(secondDie);
      imageLabel1.setText(null);*/
   }

   /**
      Private inner class that handles the event when
      the user clicks the button.
   */

   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      }
   }
   
   /**
      The main method creates an instance of the
      MyCatImage class which causes it to display
      its window.
   */
   public static void main(String[] args)
   {
      new MotionParallax();
   }
}