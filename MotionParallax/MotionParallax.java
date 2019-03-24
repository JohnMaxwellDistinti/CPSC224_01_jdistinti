/***************
MotionParallax.java
Due Date: 3/23/19
Names: John Maxwell Distinti
********************/

import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

/**
   This class demonstrates how to use an ImageIcon
   and a JLabel to display an image.
*/

public class MotionParallax extends JFrame {
   
   // represents parallax values of each aspect of the graphic
   // the farther away the object in the frame, the larger the 
   // parallax value. We also made X values increase at a larger rate
   // than the Y values for added realism.
   private int sunParallax = 350;
   private int mountainBackParallax = 140;
   private int mountainRightParallax = 95;
   private int mountainLeftParallax = 50;
   private int landscapeParallax = 5;
   
   private int delay = 30;
   private Timer timer;
   private JPanel grassPanel;     // To hold the labeln
   private JPanel skyboxPanel;     // To hold the label
   private JLabel grassLabel;     // To show an image
   private JLabel skyboxLabel;     // To show an image
   private int WINDOW_WIDTH = 700;
   private int WINDOW_HEIGHT = 700;
   private int currentX = 0;
   private int currentY = 0;

   // array of bird coordinates, the first 3 coordinates of each array refer to the x coordinates of the left
   // wing, middle of the bird, and the right wing respectively. The last 2 elements refer to the min and max
   // y coordinate of the bird (respectively).
   private int [][]birds = {{80, 85, 90, 180, 185}, {95, 100, 105, 190, 195}, {110, 115, 120, 200, 205}, {125, 130 ,135, 210, 215}, {140, 145, 150, 220, 225}};

   public MotionParallax() {
      // Set the title.
      setTitle("Motion Parallax");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());

      // adding both mouse listeners
      addMouseListener(new MyMouseListener());
      addMouseMotionListener(new MyMouseMotionListener());

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

   public void paint(Graphics g) {
      // Call the superclass's paint method.
      super.paint(g);
      

      // Draw a rectangle
      int grassWidth = 2000;
      int grassHeight = 300;
      int treeHeight = 150;
      int foliageSize = 115;
      Color skyColor = new Color(33, 192, 237);
      Color sunColor = new Color(255,255,0);
      Color mountainLeftColor = new Color(255, 163, 242);
      Color mountainRightColor = new Color(178, 255, 163);
      Color mountainBackColor = new Color(231, 56, 255);
      Color grassColor = new Color(46,198,25);
      Color treeColor = new Color(46, 100, 25);
      Color barkColor = new Color(66, 39, 39);
      Color birdColor = new Color(0,0,0);
      int mountainLeftXValues[] = {-90, 175, 440};
      int mountainLeftYValues[] = {575, 300, 575};

      int mountainRightXValues[] = {260, 525, 790};
      int mountainRightYValues[] = {575, 300, 575};

      int mountainBackXValues[] = {100, 350, 600};
      int mountainBackYValues[] = {575, 200, 575};
	   int points = 3;
      
      
      g.setColor(skyColor);
      g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
      
      g.setColor(sunColor);
      g.fillOval(550+(currentX/sunParallax), 50+(currentY/sunParallax), 100, 100);

      // draw the bird
      g.setColor(birdColor);
      for (int i = 0; i < birds.length; i++) {
         for (int j = 0; j < 3; j++) {
            birds[i][j] += 10;   // how fast the birds fly across the sky
         }
         if (birds[i][0] > 700) {
            birds[i][0] = -10;
            birds[i][1] = -5;
            birds[i][2] = 0;
         }
         for (int j = 0; j < birds[i].length; j++) {
            g.drawLine(birds[i][0], birds[i][3], birds[i][1], birds[i][4]);
            g.drawLine(birds[i][1], birds[i][4], birds[i][2], birds[i][3]);
         }
      }

      for (int i = 0; i < 3; i++) {
         mountainLeftXValues[i] += currentX / mountainLeftParallax;
         mountainLeftYValues[i] += currentY/ mountainLeftParallax;
         mountainRightXValues[i] += currentX / mountainRightParallax;
         mountainRightYValues[i] += currentY / mountainRightParallax;
         mountainBackXValues[i] += currentX / mountainBackParallax;
         mountainBackYValues[i] += currentY / mountainBackParallax;
      }

      // Back Mountain
      g.setColor(mountainBackColor);
      g.fillPolygon(mountainBackXValues, mountainBackYValues, points);

      // Right Mountain
      g.setColor(mountainRightColor);
      g.fillPolygon(mountainRightXValues, mountainRightYValues, points);
      
      // Left Mountain
      g.setColor(mountainLeftColor);
      g.fillPolygon(mountainLeftXValues, mountainLeftYValues, points);
      
      g.setColor(grassColor);
      g.fillRect(-500+(currentX/landscapeParallax), WINDOW_HEIGHT-(grassHeight/2)+(currentY/mountainBackParallax), grassWidth, grassHeight);
      
      g.setColor(barkColor);
      g.fillRect(475+(currentX/landscapeParallax),500+(currentY/mountainLeftParallax),20,treeHeight);
      
      g.setColor(treeColor);
      g.fillOval(427+(currentX/landscapeParallax), WINDOW_HEIGHT-treeHeight-foliageSize+(currentY/mountainLeftParallax), foliageSize, foliageSize+25);	
      
   }

   private class MyMouseListener implements MouseListener {
      public void mousePressed(MouseEvent e) {
         // print out the current mouse coordinates
         System.out.printf("(x = %d, y = %d)\n", e.getX(), e.getY());
      }

      public void mouseClicked(MouseEvent e) {

      }

      public void mouseReleased(MouseEvent e) {

      }

      public void mouseEntered(MouseEvent e) {

      }

      public void mouseExited(MouseEvent e) {

      }
   }

   private class MyMouseMotionListener implements MouseMotionListener {
      public void mouseDragged(MouseEvent e) {
         
      }

      public void mouseMoved(MouseEvent e) {
    	   currentX = e.getX() + (WINDOW_WIDTH/2);
    	   currentY = e.getY() + (WINDOW_HEIGHT/2);
    	   try {
			   TimeUnit.MILLISECONDS.sleep(15);
    	   } catch (InterruptedException e1) {
			   e1.printStackTrace();
    	   }
    	   repaint();
      }
   }
   public static void main(String[] args) {
      new MotionParallax();
   }
}