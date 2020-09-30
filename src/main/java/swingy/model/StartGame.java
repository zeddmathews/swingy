package swingy.model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import swingy.controller.ArtifactController;
import swingy.controller.EnemyController;
import swingy.exception.StandardException;
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
	protected int xCoord;
	protected int yCoord;
	protected int lastX;
	protected int lastY;
	protected int heroExp;
	protected int levelUpExp;
	protected int currentItems;
	protected int attack;
	protected int defense;
	protected int hp;
	protected int maxItems;

	protected int mapLimit;
	protected int mapExp;

	protected ArrayList<ArtifactController> artifactList = new ArrayList<ArtifactController>();
	protected ArrayList<EnemyController> enemyList = new ArrayList<EnemyController>();
	protected ArrayList<String> enemyLocations = new ArrayList<String>();

	protected int enemies = 0;
	protected int enemyCurHp = 0;
	protected boolean firstSpawn = true;
	protected boolean amFight = false;
	protected String fightName;
	protected final String[] directions = {
		"north",
		"south",
		"east",
		"west"
	};
	protected final String[] fightOptions = {
		"fight",
		"flee"
	};

	public StartGame(String gameMode, int heroLevel, String heroName, int xCoord, int yCoord) {
		this.gameMode = gameMode;
		this.heroLevel = heroLevel;
		this.heroName = heroName;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public void renderMap(Scanner userInput) throws StandardException {
		final int formula = (this.heroLevel - 1) * 5 + 10 - (this.heroLevel % 2);
		this.mapLimit = formula;
		System.out.println(formula);
		System.out.println(xCoord + " " + yCoord);
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
		this.mapExp = LevelUp.fetchMapExp(this.heroLevel);
		if (this.heroExp == this.levelUpExp) {
			this.heroLevel = this.heroLevel + 1;
			this.xCoord = formula;
			this.yCoord = formula;
			StartGame startGame = new StartGame(this.gameMode, this.heroLevel, this.heroName, this.xCoord, this.yCoord);
			UpdateHero.updateHero(this.heroName, this.heroClass, this.heroLevel, this.heroExp, this.attack, this.defense, this.hp, this.currentItems, this.xCoord, this.yCoord);
			startGame.renderMap(userInput);
		}
		if (this.heroLevel == 1 && this.currentItems == 0) {
			artifactList.add(ArtifactCreator.newArtifact("weapon", this.heroLevel));
			InventoryManagement.addItem(this.heroName, "weapon", "attack", artifactList.get(0).generateStats(this.heroLevel));
			this.currentItems++;
			artifactList.remove(0);
		}
		if (this.enemies == 0 && this.firstSpawn == true) {
			enemyList = EnemyHandler.enemyHandler(this.heroLevel);
			this.enemies = enemyList.size();
			enemyLocations = EnemyHandler.enemyPositions(enemyList, this.mapLimit, this.xCoord, this.yCoord);
			for (String places : enemyLocations) {
				System.out.println(places);
			}
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
			if (this.enemies > 0) {
				System.out.println("There are " + this.enemies + " enemies on the map.");
				System.out.println("Seek out enemies for experience points and a chance at some loot");
			}
			else if (this.enemies == 0) {
				System.out.println("There are no more enemies on the map");
			}
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
				this.lastX = this.xCoord;
				this.lastY = this.yCoord;
				if (movement.equals("north")) {
					this.yCoord++;
				}
				else if (movement.equals("south")) {
					this.yCoord--;
				}
				else if (movement.equals("east")) {
					this.xCoord++;
				}
				else if (movement.equals("west")) {
					this.xCoord--;
				}
				for (String badPeople : enemyLocations) {
					String shards[] = badPeople.split(" ");
					System.out.println(shards[0]);
					System.out.println(shards[1]);
					System.out.println(shards[2]);
					System.out.println(shards[3]);
					if (Integer.parseInt(shards[1]) == this.xCoord && Integer.parseInt(shards[2]) == this.yCoord) {
						this.fightName = shards[0];
						this.enemyCurHp = Integer.parseInt(shards[3]);
						System.out.println("You have encountered an enemy");
						this.amFight = true;
						break ;
					}
				}
				if (this.amFight == true) {
					do {
						System.out.println(this.enemyCurHp);
						System.out.println("Fight");
						System.out.println("Flee");
						String wantSomeFight = userInput.nextLine().toLowerCase();
						if (Arrays.asList(this.fightOptions).contains(wantSomeFight)) {
							if (wantSomeFight.equals("fight")) {
								System.out.println("want some fight?");
								if (this.enemyCurHp > 0) {
									System.out.println("You attacked" + this.fightName + " and did " + this.attack + " damage");
									this.enemyCurHp = this.enemyCurHp - this.attack;
								}
								if (this.enemyCurHp <= 0) {
									System.out.println(this.fightName + " has been defeated");
									int buyBye = 0;
									for (EnemyController deadGuys : enemyList) {
										if (deadGuys.enemyData()[0].equals(this.fightName)) {
											enemyList.remove(buyBye);
											this.enemies--;
											break ;
										}
										buyBye++;
									}
									buyBye = 0;
									for (String ded : enemyLocations) {
										String shatter[] = ded.split(" ");
										if (shatter[0].equals(this.fightName)) {
											enemyLocations.remove(buyBye);
											this.amFight = false;
											break ;
										}
										buyBye++;
									}
								}
							}
							else if (wantSomeFight.equals("flee")) {
								this.xCoord = this.lastX;
								this.yCoord = this.lastY;
								this.amFight = false;
							}
						}
						else {
							System.out.println("That's not an actual fight command");
						}
					} while(this.amFight == true);
				}
				System.out.println("Such waow");
			}
			else if (movement.equals("quit")) {
				System.out.println("Saving progress");
				UpdateHero.updateHero(this.heroName, this.heroClass, this.heroLevel, this.heroExp, this.attack, this.defense, this.hp, this.currentItems, this.xCoord, this.yCoord);
				System.out.println("Shutting down swingy...");
				System.exit(0);
			}
			else {
				System.out.println("Feels random input");
			}

		} while (this.xCoord > 0 || this.yCoord > 0 || this.xCoord < this.mapLimit || this.yCoord < this.mapLimit);
		if (this.xCoord == 0 || this.yCoord == 0 || this.xCoord == this.mapLimit || this.yCoord == this.mapLimit) {
			System.out.println("map limits reached");
			this.heroExp = this.heroExp + this.mapExp;
			this.firstSpawn = true;
			if (this.heroExp >= this.levelUpExp) {
				this.heroLevel = this.heroLevel + 1;
				this.attack = this.attack + 2;
				this.defense = this.defense + 2;
				this.hp = this.hp + 2;
				this.xCoord = formula;
				this.yCoord = formula;
				UpdateHero.updateHero(this.heroName, this.heroClass, this.heroLevel, this.heroExp, this.attack, this.defense, this.hp, this.currentItems, this.xCoord, this.yCoord);
				System.out.println("You have levelled up");
			}
			StartGame startGame =  new StartGame(this.gameMode, this.heroLevel, this.heroName, this.xCoord, this.yCoord);
			startGame.renderMap(userInput);
		}
	}
}