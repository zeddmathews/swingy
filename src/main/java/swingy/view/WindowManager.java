package swingy.view;

import java.io.BufferedReader;
// import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
// import java.awt.event.*;

import swingy.exception.StandardException;
// import swingy.util.CharacterCreator;
// import swingy.storage.HeroStorage;
import swingy.view.console.Console;
// import swingy.view.gui.Gui;


public class WindowManager {
	public static void checkSaveData() throws FileNotFoundException, IOException, StandardException {
		try {
			// HeroStorage heroStorage = new HeroStorage();
			BufferedReader bufferedReader= new BufferedReader(new FileReader("heroes.txt"));

			bufferedReader.close();
		}
		catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}

	}

	public void gameType(String type, Scanner userInput) throws FileNotFoundException, IOException, StandardException {
		try {
			checkSaveData();
			if (type.toLowerCase().equals("console")) {
				Console console = new Console();
				console.homeMenu(userInput);
				// consoleType(userInput);
			}
			else if (type.toLowerCase().equals("gui")) {
				guiType();
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// public void consoleType(Scanner userInput) throws FileNotFoundException, IOException, StandardException {

	// }

	public static void guiType() throws FileNotFoundException, IOException, StandardException {
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