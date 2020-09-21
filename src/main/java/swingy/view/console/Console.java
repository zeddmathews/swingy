package swingy.view.console;

import java.util.Scanner;

import swingy.exception.StandardException;

public class Console {
	private boolean createHero = false;
	private boolean loadHero = false;
	private boolean switchMode = false;
	private boolean quitGame = false;
	private CreateHero cH;
	private LoadHero lH;
	// private SwitchMode sM;

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
					cH = new CreateHero();
					cH.createHeroMenu(userInput);
				}
				else if (newInput.equals("load")) {
					loadHero = true;
					lH = new LoadHero();
					lH.loadHeroes(userInput);
					System.out.println("load character menu");
				}
				else if (newInput.equals("switch")) {
					switchMode = true;
					SwitchMode.switchMode("console", userInput);
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
		}
		catch (StandardException se) {
			System.out.println(se.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}