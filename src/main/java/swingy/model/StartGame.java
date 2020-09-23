package swingy.model;

import java.util.Scanner;
import java.util.ArrayList;

import swingy.util.database.LoadHeroes;

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
	protected String heroName;
	protected ArrayList<String> aList = new ArrayList<String>();
	public StartGame (String gameMode, int heroLevel, String heroName) {
		this.gameMode = gameMode;
		this.level = heroLevel;
		this.heroName = heroName;
	}

	public void renderMap(Scanner userInput) {
		final int formula = (this.level - 1) * 5 + 10 - (this.level % 2);
		String[] arr = new String[formula];
		aList = LoadHeroes.loadHero(this.heroName);
		System.out.println(aList);
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