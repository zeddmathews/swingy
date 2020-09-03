package swingy.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import swingy.storage.HeroStorage;


public class WindowManager {

	public static void checkSaveData() throws FileNotFoundException {
		try {
			HeroStorage heroStorage = new HeroStorage();
			BufferedReader bufferedReader= new BufferedReader(new FileReader("heroes.txt"));
		}
		catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}

	}

	public void gameType(String type, Scanner userInput) throws FileNotFoundException {
		if (type.toLowerCase().equals("console")) {
			consoleType(userInput);
		}
		else if (type.toLowerCase().equals("gui")) {
			guiType(userInput);
		}
	}

	public void consoleType(Scanner userInput) throws FileNotFoundException {
		checkSaveData();
		boolean running = true;
		boolean characterLoaded = false;
		System.out.println("Welcome to Swingy (Console mode)");
		System.out.println("Please enter one of the following commands to proceed:");
		System.out.println("\"Create\"\t- Create a new character");
		System.out.println("\"Load\"\t- Select a pre-existing character");
		System.out.println("\"Switch\"\t- Switch to gui mode (I wish)");
		System.out.println("\"Quit\"\t- Quit the game");
		while (userInput.hasNext()) {
			String newInput = userInput.nextLine();
			newInput = newInput.toLowerCase();
			System.out.println(newInput);
			if (newInput.equals("create")) {
				System.out.println("create new hero menu");
			}
			else if (newInput.equals("load")) {
				System.out.println("load character menu");
			}
			else if (newInput.equals("switch")) {
				System.out.println("switch to gui");
			}
			else if (newInput.equals("quit")) {
				System.out.println("Shutting down Swingy...");
				System.exit(0);
			}
		}
			System.out.println("Welcome to Swingy");
	}

	public void guiType(Scanner userInput) throws FileNotFoundException {
		checkSaveData();
		// userInput = new
	}
}