package swingy.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

import swingy.util.CharacterCreator;
import swingy.storage.HeroStorage;


public class WindowManager {

	public static void checkSaveData() throws FileNotFoundException, IOException {
		try {
			HeroStorage heroStorage = new HeroStorage();
			BufferedReader bufferedReader= new BufferedReader(new FileReader("heroes.txt"));

			bufferedReader.close();
		}
		catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}

	}

	public void gameType(String type, Scanner userInput) throws FileNotFoundException, IOException {
		if (type.toLowerCase().equals("console")) {
			consoleType(userInput);
		}
		else if (type.toLowerCase().equals("gui")) {
			guiType(userInput);
		}
	}

	public void consoleType(Scanner userInput) throws FileNotFoundException, IOException {
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
				System.out.println("Please select a class form the following list:\n\t\"Dwarf\"\n\t\"Elf\"\n\t\"Knight\"\n\t\"Mage\"""""""""");
				if (!newInput.toLowerCase().equals("dwarf") && !newInput.toLowerCase().equals("dwarf") && !newInput.toLowerCase().equals("dwarf"))
				CharacterCreator.newCharacter();
				System.out.println("Please select a name for your character");
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
			else {
				System.out.println("What the actual fuck are you smoking");
			}
		}
			System.out.println("Welcome to Swingy");
	}

	public void guiType(Scanner userInput) throws FileNotFoundException, IOException {
		checkSaveData();
		// userInput = new
		JFrame frame = new JFrame();

		JButton newGameButton = new JButton("New game");
		JButton loadGameButton = new JButton("Load game");
		JButton switchModeButton = new JButton("Switch mode");
		JButton quitGameButton = new JButton("Quit game");
		newGameButton.setBounds(100, 50, 100, 40);
		loadGameButton.setBounds(100, 100, 100, 40); // x, y, width, height
		switchModeButton.setBounds(100, 150, 100, 40);
		quitGameButton.setBounds(100, 200, 100, 40);

		frame.add(newGameButton);
		frame.add(loadGameButton);
		frame.add(switchModeButton);
		frame.add(quitGameButton);
		frame.setSize(1280, 720); // width, height
		frame.setLayout(null);
		frame.setVisible(true);
	}
}