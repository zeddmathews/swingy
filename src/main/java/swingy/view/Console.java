package swingy.view;

import java.util.Scanner;
import java.util.Arrays;

import swingy.exception.StandardException;
import swingy.util.CharacterCreator;

public class Console {
	private boolean createHero = false;
	private boolean loadHero = false;
	private boolean switchMode = false;
	private boolean quitGame = false;
	private String heroType = null;
	private String heroName = null;
	final String[] heroTypes = {
		"dwarf",
		"elf",
		"knight",
		"mage"
	};
	// final String[] menuOptions = {
	// 	"",
	// 	"",
	// 	"",
	// 	""
	// };

	public void homeMenu(Scanner userInput) throws StandardException {
		try {
			String newInput = "";
			System.out.println("Welcome to Swingy (Console mode)");
			do {
				System.out.println("Please enter one of the following commands to proceed:");
				System.out.println("\"Create\"\t- Create a new character");
				System.out.println("\"Load\"\t- Select a pre-existing character");
				System.out.println("\"Switch\"\t- Switch to gui mode (I wish)");
				System.out.println("\"Quit\"\t- Quit the game");
				try {
					newInput = userInput.nextLine();
					newInput = newInput.toLowerCase();
					// System.out.println(newInput);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if (newInput.equals("create")) {
					createHero = true;
					createHeroMenu(userInput);
				}
				else if (newInput.equals("load")) {
					loadHero = true;
					System.out.println("load character menu");
				}
				else if (newInput.equals("switch")) {
					switchMode = true;
					System.out.println("switch to gui");
				}
				else if (newInput.equals("quit")) {
					System.out.println("Shutting down Swingy...");
					System.exit(0);
				}
				else {
					System.out.println("\nWhat the actual fuck are you smoking\n");
				}
			} while (createHero == false || loadHero == false || switchMode == false || quitGame == false);

			// while (userInput.hasNext()) {
			// }
				// System.out.println("Welcome to Swingy");
		}
		catch (StandardException se) {
			System.out.println(se.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void createHeroMenu(Scanner userInput) throws StandardException {
		do {
			System.out.println("\nPlease select a class from the following list:"
			+ "\n  ->\"Dwarf\""
			+ "\n  ->\"Elf\""
			+ "\n  ->\"Knight\""
			+ "\n  ->\"Mage\""
			+ "\n  ->\"Home\"");
			try {
				this.heroType = userInput.nextLine();
				this.heroType = this.heroType.toLowerCase();
				if (!Arrays.asList(this.heroTypes).contains(this.heroType)) {
					System.out.println(this.heroType +" is not a valid hero type");
				}
				if (this.heroType.equals("home")) {
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

	private void createHeroName(Scanner userInput) throws StandardException {
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

	private void createHero() throws StandardException {
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