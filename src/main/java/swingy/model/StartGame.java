package swingy.model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import swingy.controller.ArtifactController;
// import swingy.model.artifacts.Armour;
// import swingy.model.artifacts.Helm;
// import swingy.model.artifacts.Weapon;
import swingy.util.ArtifactCreator;
import swingy.util.database.InventoryManagement;
import swingy.util.database.LevelUp;
import swingy.util.database.LoadHeroes;
import swingy.util.database.UpdateHero;

public class StartGame {
	protected String gameMode;
	protected String heroName;
	protected String heroClass;
	protected int heroLevel;
	protected ArrayList<String> aList = new ArrayList<String>();
	protected int xcoord;
	protected int ycoord;
	protected int heroExp;
	protected int levelUpExp;
	protected int currentItems;
	protected int maxItems;
	protected int attack;
	protected int defense;
	protected int hp;
	protected int mapLimit;
	protected int mapExp;
	protected ArrayList<ArtifactController> artifactList = new ArrayList<ArtifactController>();
	protected final String[] directions = {
		"north",
		"south",
		"east",
		"west"
	};

	public StartGame(String gameMode, int heroLevel, String heroName, int xcoord, int ycoord) {
		this.gameMode = gameMode;
		this.heroLevel = heroLevel;
		this.heroName = heroName;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}

	public void renderMap(Scanner userInput) {
		final int formula = (this.heroLevel - 1) * 5 + 10 - (this.heroLevel % 2);
		this.mapLimit = formula;
		System.out.println(formula);
		System.out.println(xcoord + " " + ycoord);
		aList = LoadHeroes.loadHero(this.heroName);
		int countData = 1;
		for (String wantsData: aList) {
			String splinter[] = wantsData.split(" ");
			if (splinter.length == 3 && countData == 1) {
				this.heroName = splinter[0];
				this.heroClass = splinter[1];
				this.heroLevel = Integer.parseInt(splinter[2]);
			}
			if (splinter.length == 2 && countData == 2) {
				String scatter[] = splinter[1].split("/");
				this.heroExp = Integer.parseInt(scatter[0]);
				this.levelUpExp = Integer.parseInt(scatter[1]);
			}
			if (splinter.length == 6 && countData == 3) {
				this.attack = Integer.parseInt(splinter[1]);
				this.defense = Integer.parseInt(splinter[3]);
				this.hp = Integer.parseInt(splinter[5]);
			}
			if (splinter.length == 2 && countData == 4) {
				String scatter[] = splinter[1].split("/");
				this.currentItems = Integer.parseInt(scatter[0]);
				this.maxItems = Integer.parseInt(scatter[1]);
			}
			countData++;
		}
		// System.out.println(this.currentItems);
		this.mapExp = LevelUp.fetchMapExp(this.heroLevel);
		if (this.heroExp == this.levelUpExp) {
			this.heroLevel = this.heroLevel + 1;
			StartGame startGame = new StartGame(this.gameMode, this.heroLevel, this.heroName, this.xcoord, this.ycoord);
			UpdateHero.updateHero(this.heroName, this.heroClass, this.heroLevel, this.heroExp, this.attack, this.defense, this.hp, this.currentItems, this.xcoord, this.ycoord);
			startGame.renderMap(userInput);
		}
		if (this.heroLevel == 1 && this.currentItems == 0) {
			this.currentItems++;
			// weapon = new Weapon("Sword", 10, this.heroLevel);
			artifactList.add(ArtifactCreator.newArtifact("weapon", 10, this.heroLevel));
			InventoryManagement.addItem(this.heroName, "weapon", "attack", artifactList.get(0).generateStats(this.heroLevel));
			System.out.println("give item");
		}
		System.out.println("The point of the game is to, other than waste one's time, get to the outer edges of the map.");
		System.out.println("You have access to 4 directions of movement: \n->North\t->South\t->East\t->West");
		System.out.println("Simply getting to the end of the map is insufficient however; in order to progress your character must level up.");
		System.out.println("In order to level up, you must defeat enemies (or just continuously walk to the end of the map but you can't get new items without fighting).");
		do {
			for (String heroData : aList) {
				System.out.println(heroData);
			}
			System.out.println("You find yourself in a random location (I don't care where; use your imagination)");
			System.out.println("You think to yourself, \"I should probably wander around and kill anything I come across because they're probably hostile and I have nothing better to do with my time anyways\".");
			System.out.println(
				"Pick a direction to move in:\n" +
				"\t->\"North\"" +
				"\t->\"South\"" +
				"\t->\"East\"" +
				"\t->\"West\"" +
				"\n->\"Quit\""
				);
			String movement = userInput.nextLine().toLowerCase();
			if (Arrays.asList(this.directions).contains(movement)) {
				if (movement.equals("north")) {
					this.ycoord++;
				}
				else if (movement.equals("south")) {
					this.ycoord--;
				}
				else if (movement.equals("east")) {
					this.xcoord++;
				}
				else if (movement.equals("west")) {
					this.xcoord--;
				}
				System.out.println("Such waow");
			}
			else if (movement.equals("quit")) {
				System.out.println("Saving progress");
				UpdateHero.updateHero(this.heroName, this.heroClass, this.heroLevel, this.heroExp, this.attack, this.defense, this.hp, this.currentItems, this.xcoord, this.ycoord);
				//don't forget to update shit
				System.out.println("Shutting down swingy...");
				System.exit(0);
			}
			else {
				System.out.println("Feels random input");
			}

		} while (this.xcoord > 0 || this.ycoord > 0 || this.xcoord < this.mapLimit || this.ycoord < this.mapLimit);
		if (this.xcoord == 0 || this.ycoord == 0 || this.xcoord == this.mapLimit || this.ycoord == this.mapLimit) {
			System.out.println("map limits reached");
			this.heroExp = this.heroExp + this.mapExp;
			if (this.heroExp >= this.levelUpExp) {
				// this.heroExp
				UpdateHero.updateHero(this.heroName, this.heroClass, this.heroLevel, this.heroExp, this.attack, this.defense, this.hp, this.currentItems, this.xcoord, this.ycoord);
				System.out.println("You have levelled up");
				StartGame startGame =  new StartGame(this.gameMode, this.heroLevel, this.heroName, this.xcoord, this.ycoord);
				startGame.renderMap(userInput);
			}
		}
		// System.out.println(arr);
	}
}