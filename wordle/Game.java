package wordle;
import java.util.Scanner;


public class Game {
	
	private Guess[] guesses = new Guess[6];
	private int turn=0;
	private String word;
	private Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		Game g = new Game();
		g.start();
	}
	
	public Game() {
		for (int i = 0;i<6;i++) {
			guesses[i] = new Guess();
		}
		word = "hello";
	}
	// add a method that opens a menu
	public void start() {
		do {
			startTurn();
		} while (turn < 6 && !guesses[turn-1].isCorrect());
		System.out.println("\n\nGame results:");
		System.out.println(toString());
		System.out.println(guesses[turn-1].isCorrect()?"You won! :)":"You lost! :(");
	}
	
	public void startTurn() {
		System.out.println("Turn #" + (turn+1));
		System.out.println(toString());
		System.out.print(String.format("Enter guess #%d:",turn+1));
		String input = scnr.next();
		System.out.println();
		guesses[turn].input(input,word);
		turn++;
	}
	
	
	
	@Override
	public String toString() {
		String r = "";
		r += "===========\n";
		for (Guess g : guesses) {
			r += g + "\n";
		}
		r += "===========";
		return r;
	}
}
