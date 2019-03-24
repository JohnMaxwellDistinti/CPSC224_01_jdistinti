// John Maxwell Distinti and Kevin Mattappally
// GitHub repository: https://github.com/JohnMaxwellDistinti/CPSC224_01_jdistinti
// Simulates the concept of motion parallax with the use of mouse listeners. Contains
// mouse motion listeners to simulate the parallax, contains a timer to time when the 
// graphics gets repainted, and contains mouse listeners for other aspects
// Depicts a landscape with a sky, three mountains, a grassy field, and a tree.

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MotionParallax extends JFrame implements ActionListener {
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
   private int WINDOW_WIDTH = 700;
   private int WINDOW_HEIGHT = 700;
   private int currentX = 0;
   private int currentY = 0;

   // array of bird coordinates, the first 3 coordinates of each array refer to the x coordinates of the left
   // wing, middle of the bird, and the right wing respectively. The last 2 elements refer to the min and max
   // y coordinate of the bird (respectively).
   private int [][]birds = {{80, 85, 90, 180, 185}, {95, 100, 105, 190, 195}, {110, 115, 120, 200, 205}, {125, 130 ,135, 210, 215}, {140, 145, 150, 220, 225}};
   // represents how fast the birds fly
   private int birdSpeed = 5;

   private int []testCircle = {40, 60, 30, 30};
   private Color red = new Color(255, 0, 0);
   private Color green = new Color(0, 255, 0);
   private Color blue = new Color(0, 0, 255);
   private Color current = blue;

   // This shows the current positions of the mouse
   private String mouseCoords = "(x = 50, y = 50)";

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

      // starts the timer
      timer = new Timer(delay, this);
      timer.start();

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

      // initializes all the aspects of what we need
      // to initially draw onto the frame. Includes
      // colors, coordinates, heights, and widths
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
      Color birdColor = new Color(0, 0, 0);
      int mountainLeftXValues[] = {-90, 175, 440};
      int mountainLeftYValues[] = {575, 300, 575};
      int mountainRightXValues[] = {260, 525, 790};
      int mountainRightYValues[] = {575, 300, 575};
      int mountainBackXValues[] = {100, 350, 600};
      int mountainBackYValues[] = {575, 200, 575};
      int points = 3;
      
      // draws the sky
      g.setColor(skyColor);
      g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
      
      // draws the sun
      g.setColor(sunColor);
      g.fillOval(550+(currentX/sunParallax), 50+(currentY/sunParallax), 100, 100);

      // draws the circle
      g.setColor(current);
      g.fillOval(testCircle[0], testCircle[1], testCircle[2], testCircle[3]);

      // draws all the birds going across the sky
      g.setColor(birdColor);
      for (int i = 0; i < birds.length; i++) {
         for (int j = 0; j < 3; j++) {
            birds[i][j] += birdSpeed;   // how fast the birds fly across the sky
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

      // draws out the current coordinates of the mouse
      g.setColor(birdColor);
      g.drawString(mouseCoords, 10, 150);

      // calculates the parallax values for all the mountains
      for (int i = 0; i < 3; i++) {
         mountainLeftXValues[i] += currentX / mountainLeftParallax;
         mountainLeftYValues[i] += currentY/ mountainLeftParallax;
         mountainRightXValues[i] += currentX / mountainRightParallax;
         mountainRightYValues[i] += currentY / mountainRightParallax;
         mountainBackXValues[i] += currentX / mountainBackParallax;
         mountainBackYValues[i] += currentY / mountainBackParallax;
      }

      // draws out the mountain at the back
      g.setColor(mountainBackColor);
      g.fillPolygon(mountainBackXValues, mountainBackYValues, points);

      // draws out the mountain on the right
      g.setColor(mountainRightColor);
      g.fillPolygon(mountainRightXValues, mountainRightYValues, points);
      
      // draws out the mountain on the left
      g.setColor(mountainLeftColor);
      g.fillPolygon(mountainLeftXValues, mountainLeftYValues, points);
      
      // draws out the grass
      g.setColor(grassColor);
      g.fillRect(-500+(currentX/landscapeParallax), WINDOW_HEIGHT-(grassHeight/2)+(currentY/mountainBackParallax), grassWidth, grassHeight);
      
      // draws out the bark of the tree
      g.setColor(barkColor);
      g.fillRect(475+(currentX/landscapeParallax),500+(currentY/mountainLeftParallax),20,treeHeight);
      
      // draws out the leaves of the tree
      g.setColor(treeColor);
      g.fillOval(427+(currentX/landscapeParallax), WINDOW_HEIGHT-treeHeight-foliageSize+(currentY/mountainLeftParallax), foliageSize, foliageSize+25);	
   }

   public void actionPerformed(ActionEvent e) {
      // will run when the timer fires
      repaint();
   }

   private class MyMouseListener implements MouseListener {
      public void mousePressed(MouseEvent e) {
         // implementation not needed
      }

      public void mouseClicked(MouseEvent e) {
         // print out the current mouse coordinates
         System.out.printf("(x = %d, y = %d)\n", e.getX(), e.getY());
         current = green;
      }

      public void mouseReleased(MouseEvent e) {
         // implementation not needed
      }

      public void mouseEntered(MouseEvent e) {
         current = red;
      }

      public void mouseExited(MouseEvent e) {
         current = blue;
      }
   }

   private class MyMouseMotionListener implements MouseMotionListener {
      public void mouseDragged(MouseEvent e) {
         mouseCoords = "(x = " + e.getX() + " y = " + e.getY() + ")";
      }

      public void mouseMoved(MouseEvent e) {
         // parallax movement happens when the mouse is moved
         currentX = e.getX() + (WINDOW_WIDTH / 2);
    	   currentY = e.getY() + (WINDOW_HEIGHT / 2);
      }
   }
   public static void main(String[] args) {
      new MotionParallax();
   }
}