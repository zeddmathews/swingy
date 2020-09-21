package swingy.model;

import java.util.Scanner;

public class StartGame {
	// public String gameMode;
	// public Game(String gameMode) {
	// 	this.gameMode = gameMode;
	// }

	// public void startGame() {
	// 	if (this.gameMode.equals("console")) {

	// 	}
	// 	else if (this.gameMode.equals("gui")) {

	// 	}
	// 	else {
	// 		throw new StandardException("Invalid input type");
	// 	}
	// }
	protected String gameMode;
	protected int level;
	protected final int formula = (level - 1) * 5 + 10 - (level % 2);
	public StartGame (String gameMode, int heroLevel) {
		this.gameMode = gameMode;
	}

	public void renderMap(Scanner userInput) {
		String[] arr = new String[formula];
		System.out.println(arr);
		System.out.println(formula + "x" + formula);
	}
}