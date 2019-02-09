// Kevin Mattappally and Max Distinti
// GitHub repository: https://github.com/JohnMaxwellDistinti/CPSC224_01_jdistinti
// Hangman game that interacts with the player using JOptionPane (Java GUI)
// The player tries to guess the word within 6 tries. If the player guesses
// the correct word, they win, otherwise they lose.

import javax.swing.JOptionPane;
import java.lang.String;
import java.util.*;

public class Hangman {
	public static void main(String[] args) {
		driveGame();
	}

	public static void driveGame() {
		introduceGame();
		char userChoice = displayMenu().charAt(0);
		String wordToGuess = executeGameStart(userChoice);
		String wordDisplay = "";
		for (int i = 0; i < wordToGuess.length(); i++) {
			wordDisplay += "_";
		}
		executeGameFlow(wordToGuess, wordDisplay, 6);
		playAgain();
	}

	public static void displayGuess(String currWord, String currDisplay) {
		int DISPLAYLEN = 25; //number of characters in hangman display line
		String spaceHelper = "";
		for (int k = 0; k < ((DISPLAYLEN / 2) - currWord.length() - 1); k++) {
			spaceHelper += " ";
		}
		JOptionPane.showMessageDialog(null, "** HANGMAN **" + '\n' + "*****************" + '\n' + '\n' + "---------------------" + '\n' + '\n' +
		spaceHelper + currDisplay + '\n' + "---------------------" + '\n' + "*****************");
	}

	public static void displayMan(boolean hasHead, boolean hasTorso, boolean hasRightArm, boolean hasLeftArm, boolean hasRightLeg, boolean hasLeftLeg) {
		String head = "    |         O";
		String torso = "/|\\";
		String legs = "    |        / \\";
		if (!hasHead) {
			head = head.substring(0, head.length() - 1);
		}
		if (!hasTorso) {
			torso = torso.replace('|', ' ');
		}
		if (!hasRightArm) {
			torso = torso.replace('\\', ' ');
		}
		if (!hasLeftArm) {
			torso = torso.replace('/', ' ');
		}
		if (!hasRightLeg) {
			legs = legs.replace('\\', ' ');
		}
		if (!hasLeftLeg) {
			legs = legs.replace('/', ' ');
		}
		JOptionPane.showMessageDialog(null, "    _________" + '\n' + "    |         |" + '\n' + head + '\n' + "    |        " + torso + '\n' +
		legs + '\n' + "    |" + '\n' + "    |" + '\n' + "_________");
	}

	public static void introduceGame() {
		String instructions = "";
		instructions += "Welcome to Hangman!\n";
		instructions += "Try to guess the letters of the secret word.\n";
		instructions += "Each incorrect guess results in a part of the man being hung.\n";
		instructions += "The game is over when the man is fully hanged, or the correct word is guessed.";
		JOptionPane.showMessageDialog(null, instructions);
	}

	public static String displayMenu() {
		String menuOptions = "";
		menuOptions += "Please choose from the following options: \n"; 
		menuOptions += "\t(1) Play game from a randomly chosen word in a list\n"; 
		menuOptions += "\t(2) Play game from a word entered by another user\n"; 
		menuOptions += "\t(3) Exit Game";
		return JOptionPane.showInputDialog(menuOptions);
	}

	public static String executeGameStart(char userChoice) {
		switch (userChoice) {
			case '1':
				return playGameRandomWord();
			case '2':
				return playGameUserWord();
			case '3':
				JOptionPane.showMessageDialog(null, "Thanks for playing!");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Please enter a valid number");
				char newUserChoice = displayMenu().charAt(0);
				return executeGameStart(newUserChoice);
		}
	}

	public static String playGameRandomWord() {
		String list[] = {"apple", "peach", "java", "clock", "bottle", "berry",
						 "phone", "candy", "dawn", "keys", "book", "coffee"};
	    Random rand = new Random();
		int randomWordIndex = rand.nextInt(list.length);
		String wordToGuess = list[randomWordIndex];
		return wordToGuess;
	}

	public static String playGameUserWord() {
		String wordToGuess = JOptionPane.showInputDialog("Please enter a word for someone else to guess").toLowerCase();
		for (int i = 0; i < wordToGuess.length(); i++) {
			if (wordToGuess.charAt(i) < 'a' || wordToGuess.charAt(i) > 'z') {
				JOptionPane.showMessageDialog(null, "Invalid entry, please enter only alphabets.");
				return playGameUserWord();
			}
		}
		return wordToGuess;
	}

	public static void executeGameFlow(String wordToGuess, String wordDisplay, int strikesLeft) {
		System.out.println("Now executing game flow");
		switch (strikesLeft) {
			case 6:
				displayMan(false, false, false, false, false, false);
				break;
			case 5:
				displayMan(true, false, false, false, false, false);
				break;
			case 4:
				displayMan(true, true, false, false, false, false);
				break;
			case 3:
				displayMan(true, true, true, false, false, false);
				break;
			case 2:
				displayMan(true, true, true, true, false, false);
				break;
			case 1:
				displayMan(true, true, true, true, true, false);
				break;
			default:
				displayMan(true, true, true, true, true, true);
		}
		displayGuess(wordToGuess, wordDisplay);
		if (!wordDisplay.contains("_")) {
			JOptionPane.showMessageDialog(null, "Congratulations! You have guessed the word correctly! That's solid!");
			return;
		} else if (strikesLeft == 0) {
			JOptionPane.showMessageDialog(null, "Sorry, you are out of guesses. You don't even know what's going on anymore. The correct word is " + wordToGuess);
			return;
		}
		char letterGuessed;
		do {
			letterGuessed = JOptionPane.showInputDialog("Strikes Left: " + strikesLeft + "\nPlease enter an alphabet to guess: ").toLowerCase().charAt(0);
		} while (letterGuessed < 'a' || letterGuessed > 'z');
		String newDisplay = "";
		boolean isCorrectGuess = false;
		for (int i = 0; i < wordToGuess.length(); i++) {
			if (wordDisplay.charAt(i) == '_') {
				if (wordToGuess.charAt(i) == letterGuessed) {
					newDisplay += letterGuessed;
					isCorrectGuess = true;
				} else {
					newDisplay += '_';
				}
			} else {
				newDisplay += wordDisplay.charAt(i);
			}
		}
		if (!isCorrectGuess) {
			strikesLeft--;
		}
		executeGameFlow(wordToGuess, newDisplay, strikesLeft);
	}

	public static void playAgain() {
		char userChoice = JOptionPane.showInputDialog(null, "Would you like to play again?").toLowerCase().charAt(0);
		switch (userChoice) {
			case 'y':
				driveGame();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Thanks for playing!");
		}
	}
}
