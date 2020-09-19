package swingy.view.console;

import java.util.Scanner;
import java.util.Arrays;

import swingy.exception.StandardException;
import swingy.util.CharacterCreator;

public class CreateHero {
	private String heroType = null;
	private String heroName = null;
	// private Scanner userInput = null;
	final String[] heroTypes = {
		"dwarf",
		"elf",
		"knight",
		"mage"
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
					String yesNo = null;
					while (true) {
						System.out.print("Are you sure you would like your hero's name to be: " + this.heroName + "\n");
						yesNo = userInput.nextLine();
						yesNo = yesNo.toLowerCase();
						if (yesNo.equals("yes")) {
							confirmHeroName = true;
							break ;
						}
						else if (yesNo.equals("no")) {
							this.heroName = null;
							break ;
						}
						else {
							System.out.println("Invalid option");
						}
					}

				}
			} while (confirmHeroName == false);
			createHero();
		}
		catch (StandardException se) {
			System.out.println(se.getMessage());
		}
	}

	public void createHero() throws StandardException {
		try {
			String[] heroArtifacts = {};
			CharacterCreator.newCharacter(this.heroName, this.heroType, 1, 0, heroArtifacts);
			System.out.println("Character successfully created");
		}
		catch (StandardException se) {
			System.out.println(se.getMessage());
		}
	}
}