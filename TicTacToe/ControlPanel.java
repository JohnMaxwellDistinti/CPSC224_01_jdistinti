// package Bagel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {
	public ControlPanel() {
		setLayout(new GridLayout(1, 3));
		JButton NewGame = new JButton();
		JButton Reset = new JButton();
		JButton Exit = new JButton();      
		NewGame.setText("New Game");
		Reset.setText("Reset");
		Exit.setText("Exit");   
		add(NewGame);
		add(Reset);
		add(Exit);
	}
}
