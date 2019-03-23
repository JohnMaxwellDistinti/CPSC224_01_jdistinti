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
   private JLabel skyboxLabel;     // To show an image
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
      
      //grassPanel = new JPanel();
      //grassLabel = new JLabel("");

      // Add the panels to the content pane.
      //add(grassPanel, BorderLayout.SOUTH);
      
      //grassPanel.add(grassLabel);
      
      // Read the image file into an ImageIcon object.
      //ImageIcon landscape = new ImageIcon("nicelandscape.png");
      
      // Display the image in the label.
      //grassLabel.setIcon(landscape);
      //grassLabel.setText(null);

      // Pack the frame again to accomodate the 
      // new size of the label.
      pack();
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setVisible(true);
   }

   /**
      The buildImagePanel method adds a label to a panel.
   */

   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      super.paint(g);
      

      // Draw a rectangle
      int grassWidth = 1000;
      int grassHeight = 150;
      int treeHeight = 150;
      int foliageSize = 115;
      Color skyColor = new Color(33, 192, 237);
      Color sunColor = new Color(255,255,0);
      Color grassColor = new Color(46,198,25);
      Color treeColor = new Color(46, 100, 25);
      Color barkColor = new Color(66, 39, 39);
      
      g.setColor(skyColor);
      g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
      
      g.setColor(sunColor);
      g.fillOval(550, 50, 100, 100);
      
      g.setColor(grassColor);
      g.fillRect(0, WINDOW_HEIGHT-grassHeight, grassWidth, grassHeight);
      
      g.setColor(barkColor);
      g.fillRect(475,500,20,treeHeight);
      
      g.setColor(treeColor);
      g.fillOval(427, WINDOW_HEIGHT-treeHeight-foliageSize, foliageSize, foliageSize+25);	
      
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