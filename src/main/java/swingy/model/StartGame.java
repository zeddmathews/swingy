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
	protected int xcoord;
	protected int ycoord;

	public StartGame(String gameMode, int heroLevel, String heroName, int xcoord, int ycoord) {
		this.gameMode = gameMode;
		this.level = heroLevel;
		this.heroName = heroName;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}

	public void renderMap(Scanner userInput) {
		final int formula = (this.level - 1) * 5 + 10 - (this.level % 2);
		System.out.println(formula);
		System.out.println(xcoord + " " + ycoord);
		// String[] arr = new String[formula];
		aList = LoadHeroes.loadHero(this.heroName);
		for (String heroData : aList) {
				System.out.println(heroData);
			}
		System.out.println("The point of the game is to, other than waste one's time, get to the outer edges of the map.");
		System.out.println("You have access to 4 directions of movement: ->North\t->South\t->East\t->West");
		System.out.println("Simply getting to the end of the map is insufficient however; in order to progress your character must level up.");
		do {
			System.out.println("You find yourself in a random location (I don't care where; use your imagination)");
			String movement = userInput.nextLine().toLowerCase();

		} while (xcoord > 0 || ycoord > 0 || xcoord < 9 || ycoord < 9);
		// System.out.println(arr);
	}
}