// package Bagel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*; 

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {
	public JButton newGame;
	public JButton reset;
	public JButton exit;
	public ControlPanel() {
		setLayout(new GridLayout(1, 3));
		newGame = new JButton();
		reset = new JButton();
		exit = new JButton();      
		newGame.setText("New Game");
		reset.setText("Reset");
		exit.setText("Exit");  
		exit.addActionListener(new ExitButtonListener());
		add(newGame);
		add(reset);
		add(exit);
	}

	private class newGameButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		  System.exit(0);
		}
	 }

	private class resetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	 }

	private class ExitButtonListener implements ActionListener {
      	public void actionPerformed(ActionEvent e) {
			System.exit(0);
      	}
   	}
}
