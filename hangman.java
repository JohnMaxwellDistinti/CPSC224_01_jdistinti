import javax.swing.JOptionPane;
import java.lang.String;
import java.util.Random;
public class hangman {
	public static void main(String[] args) {
		String list[] = {"apple", "peach", "java", "clock", "bottle", "berry",
						 "phone", "candy", "dawn", "keys", "book", "coffee"};
	    Random rand = new Random();
		int randomWord = rand.nextInt(list.length);
		displayMan(true, false, true, true, true, true);
		
		System.exit(0);
	}
	public static void displayGuess(String currWord) {
		int DISPLAYLEN = 25; //number of characters in hangman display line
		String spaceHelper = "";
		String wordDisplay = "";
		for(int k = 0; k < ((DISPLAYLEN / 2) - currWord.length()-1); k++) {
			spaceHelper += " ";
		}
		for(int i = 0; i < currWord.length(); i++) {
			wordDisplay += "_ ";
		}
		JOptionPane.showMessageDialog(null, "** HANGMAN **" + '\n' + "*****************" + '\n' + '\n' + "---------------------" + '\n' + '\n' +
		spaceHelper + wordDisplay + '\n' + "---------------------" + '\n' + "*****************");
	}
	public static void displayMan(boolean hasHead, boolean hasTorso, boolean hasRightArm, boolean hasLeftArm, boolean hasRightLeg, boolean hasLeftLeg) {
		String head = "    |         O";
		String torso = "/|\\";
		String legs = "    |        / \\";
		if(!hasHead) {
			head = head.substring(0,head.length()-1);
		}
		if(!hasTorso) {
			torso = torso.replace('|', ' ');
		}
		if(!hasRightArm) {
			torso = torso.replace('\\', ' ');
		}
		if(!hasLeftArm) {
			torso = torso.replace('/', ' ');
		}
		if(!hasRightLeg) {
			legs = legs.replace('\\', ' ');
		}
		if(!hasLeftLeg) {
			legs = legs.replace('/', ' ');
		}
		JOptionPane.showMessageDialog(null, "    _________" + '\n' + "    |         |" + '\n' + head + '\n' + "    |        " + torso + '\n' +
		legs + '\n' + "    |" + '\n' + "    |" + '\n' + "_________");
	}
}
