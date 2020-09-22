package swingy.view.console;

import java.util.Scanner;
import java.util.ArrayList;

import swingy.model.StartGame;
import swingy.util.database.LoadHeroes;

public class LoadHero {
	private boolean heroSelected = false;
	private ArrayList<String> aList;
	private StartGame startGame;
	public void loadHeroes(Scanner userInput) {
		try {
			String newInput = null;
			aList = LoadHeroes.loadHeroes();
			System.out.println(aList);
			// while (rSet.next()) {
			// 	System.out.println(
			// 		"Name " + rSet.getString("heroName") +
			// 		"\tClass " + rSet.getString("heroClass") +
			// 		"\tLevel " +rSet.getInt("heroLevel") +
			// 		"\tExperience " +rSet.getInt("heroExp") +
			// 		"\tAttack " +rSet.getInt("attack") +
			// 		"\tDefense " +rSet.getInt("defense") +
			// 		"\tHP " +rSet.getInt("hp") +
			// 		"\tInventory " +rSet.getInt("inventory") + "/10"
			// 	);
			// }
			do {
				System.out.println("Please select a hero");
				try {
					newInput = userInput.nextLine();
					newInput = newInput.toLowerCase();
					if (!aList.contains(newInput)) {
						System.out.println("such waow");
					}
					else {
						System.out.println("feelsbadman");
						while (true) {
							System.out.println("Are you sure you would like to load the hero: " + newInput);
							if (newInput.equals("yes") || newInput.equals("y")) {
								heroSelected = true;
								break ;
							}
							else if (newInput.equals("no") || newInput.equals("n")) {
								break ;
							}
							else {
								System.out.println("Invalid option");
							}
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} while (heroSelected == false);
			startGame = new StartGame("console", 1); // need to make alist give int level
			startGame.renderMap(userInput);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}