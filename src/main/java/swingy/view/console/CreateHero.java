package swingy.view.console;

import java.util.Scanner;
import java.util.Arrays;

import swingy.exception.StandardException;
import swingy.model.StartGame;
import swingy.model.characters.classes.Dwarf;
import swingy.model.characters.classes.Elf;
import swingy.model.characters.classes.Knight;
import swingy.model.characters.classes.Mage;
import swingy.util.CharacterCreator;
import swingy.util.database.CheckExists;
import swingy.util.database.InsertHero;

public class CreateHero {
	private String heroType = null;
	private String heroName = null;
	private StartGame startGame;
	// private Scanner userInput = null;
	final String[] heroTypes = {
		"dwarf",
		"elf",
		"knight",
		"mage"
	};
	private int[] stats = {
		0,
		0,
		0
	};
	public void createHeroMenu(Scanner userInput) throws StandardException {
		do {
			System.out.println("\nPlease select a class from the following list:"
			+ "\n  ->\"Dwarf\""
			+ "\n  ->\"Elf\""
			+ "\n  ->\"Knight\""
			+ "\n  ->\"Mage\""
			+ "\n  ->\"Cancel\"");
			try {
				this.heroType = userInput.nextLine();
				this.heroType = this.heroType.toLowerCase();
				if (!Arrays.asList(this.heroTypes).contains(this.heroType)) {
					System.out.println(this.heroType +" is not a valid hero type");
				}
				if (this.heroType.equals("cancel")) {
					this.heroType = null;
					return ;
				}
				// System.out.println(this.heroType);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while(!Arrays.asList(this.heroTypes).contains(this.heroType));
		try {
			createHeroName(userInput);
		}
		catch (StandardException se) {
			System.out.println(se.getMessage());
		}
	}

	public void createHeroName(Scanner userInput) throws StandardException {
		boolean confirmHeroName = false;
		try {
			do {
				System.out.println("Please create a name for your hero");
				this.heroName = userInput.nextLine();
				this.heroName = this.heroName.toLowerCase();
				System.out.println(this.heroName);
				if (this.heroName != null) {
					boolean heroNameFound = CheckExists.checkHero(this.heroName);
					if (heroNameFound == false) {
						String yesNo = null;
						while (true) {
							System.out.print("Are you sure you would like your hero's name to be: " + this.heroName + "\n");
							System.out.println("Yes/No");
							yesNo = userInput.nextLine();
							yesNo = yesNo.toLowerCase();
							if (yesNo.equals("yes") || yesNo.equals("y")) {
								confirmHeroName = true;
								break ;
							}
							else if (yesNo.equals("no") || yesNo.equals("n")) {
								this.heroName = null;
								break ;
							}
							else {
								System.out.println("Invalid option");
							}
						}
					}
					else {
						System.out.println(this.heroName + " has been taken");
					}
				}
			} while (confirmHeroName == false);
			createHero(userInput);
		}
		catch (StandardException se) {
			System.out.println(se.getMessage());
		}
	}

	public void createHero(Scanner userInput) throws StandardException {
		try {
			String[] heroArtifacts = {};
			CharacterCreator.newCharacter(this.heroName, this.heroType, 1, 0, heroArtifacts);
			if (this.heroType.equals("dwarf")) {
				String [] heroStats = Dwarf.defaultStats();
				int i = 0;
				for (String unsplitSats : heroStats) {
					String splitStat[] = unsplitSats.split(" ");
					if (i == 0) {
						stats[0] = Integer.parseInt(splitStat[1]);
					}
					if (i == 1) {
						stats[1] = Integer.parseInt(splitStat[1]);
					}
					if (i == 2) {
						stats[2] = Integer.parseInt(splitStat[1]);
					}
					i++;
				}
			}
			else if (this.heroType.equals("elf")) {
				String [] heroStats = Elf.defaultStats();
				int i = 0;
				for (String unsplitSats : heroStats) {
					String splitStat[] = unsplitSats.split(" ");
					if (i == 0) {
						stats[0] = Integer.parseInt(splitStat[1]);
					}
					if (i == 1) {
						stats[1] = Integer.parseInt(splitStat[1]);
					}
					if (i == 2) {
						stats[2] = Integer.parseInt(splitStat[1]);
					}
					i++;
				}
			}
			else if (this.heroType.equals("knight")) {
				String [] heroStats = Knight.defaultStats();
				int i = 0;
				for (String unsplitSats : heroStats) {
					String splitStat[] = unsplitSats.split(" ");
					if (i == 0) {
						stats[0] = Integer.parseInt(splitStat[1]);
					}
					if (i == 1) {
						stats[1] = Integer.parseInt(splitStat[1]);
					}
					if (i == 2) {
						stats[2] = Integer.parseInt(splitStat[1]);
					}
					i++;
				}
			}
			else if (this.heroType.equals("mage")) {
				String [] heroStats = Mage.defaultStats();
				int i = 0;
				for (String unsplitSats : heroStats) {
					String splitStat[] = unsplitSats.split(" ");
					if (i == 0) {
						stats[0] = Integer.parseInt(splitStat[1]);
					}
					if (i == 1) {
						stats[1] = Integer.parseInt(splitStat[1]);
					}
					if (i == 2) {
						stats[2] = Integer.parseInt(splitStat[1]);
					}
					i++;
				}
			}
			// use formula to get default spawn point
			final int formula = (1 - 1) * 5 + 10 - (1 % 2);
			InsertHero.insertHero(this.heroName, this.heroType, 1, 0, stats[0], stats[1], stats[2], formula/2, formula/2);
			System.out.println("Character successfully created");
			startGame = new StartGame("console", 1, this.heroName, formula/2, formula/2);
			startGame.renderMap(userInput);
		}
		catch (StandardException se) {
			System.out.println(se.getMessage());
		}
	}
}