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
	public StartGame (String gameMode, int heroLevel) {
		this.gameMode = gameMode;
		this.level = heroLevel;
	}

	public void renderMap(Scanner userInput) {
		final int formula = (this.level - 1) * 5 + 10 - (this.level % 2);
		String[] arr = new String[formula];
		for (int i = 0; i < formula; i++) {
			arr[i] = "*";
		}
		for (String test : arr) {
			System.out.println(test);
		}
		do {
			//handle limits of map
		} while (true);
		// System.out.println(arr);
	}
}