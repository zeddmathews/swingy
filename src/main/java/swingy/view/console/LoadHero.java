package swingy.view.console;

import java.util.Scanner;
// import java.util.Arrays;
import java.util.ArrayList;

import swingy.model.StartGame;
import swingy.util.database.LoadHeroes;

public class LoadHero {
	private boolean heroSelected = false;
	private ArrayList<String> aList;
	private ArrayList<String> heroName = new ArrayList<String>();
	private ArrayList<String> heroLevel =  new ArrayList<String>();
	private ArrayList<String> xcoord =  new ArrayList<String>();
	private ArrayList<String> ycoord =  new ArrayList<String>();
	private StartGame startGame;
	private String yesNo = null;
	private String loadCharacter = null;
	public void loadHeroes(Scanner userInput) {
		try {
			String newInput = null;
			aList = LoadHeroes.loadHeroes();
			for (String heroData : aList) {
				String[] split = heroData.split(" ");
				heroName.add(split[0]);
				heroLevel.add(split[1]);
				xcoord.add(split[2]);
				ycoord.add(split[3]);
			}
			System.out.println(heroLevel);
			do {
				System.out.println("Please select a hero");
				for (String hName : heroName) {
					System.out.println(hName);
				}
				System.out.println("\n\"Cancel\"");
				try {
					newInput = userInput.nextLine();
					newInput = newInput.toLowerCase();
					if (heroName.contains(newInput)) {
						System.out.println("such waow");
						this.loadCharacter = newInput;
						System.out.println("feelsbadman");
						while (true) {
							System.out.println("Are you sure you would like to load the hero: " + newInput);
							System.out.println("Yes/No");
							yesNo = userInput.nextLine();
							yesNo = yesNo.toLowerCase();
							if (yesNo.equals("yes") || yesNo.equals("y")) {
								heroSelected = true;
								break ;
							}
							else if (yesNo.equals("no") || yesNo.equals("n")) {
								this.loadCharacter = null;
								break ;
							}
							else {
								System.out.println("Invalid option");
							}
						}
					}
					else if (newInput.equals("cancel")) {
						break ;
					}
					else {
						System.out.println("Invalid option");
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} while (heroSelected == false);
			if (heroSelected == true) {
				int getIndex = heroName.indexOf(newInput);
				startGame = new StartGame("console", Integer.parseInt(heroLevel.get(getIndex)), this.loadCharacter,
						Integer.parseInt(xcoord.get(getIndex)), Integer.parseInt(ycoord.get(getIndex))); // need to make alist give int level
				startGame.renderMap(userInput);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}