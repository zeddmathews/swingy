package swingy.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import swingy.exception.StandardException;
import swingy.view.console.Console;
import swingy.view.gui.Gui;


public class WindowManager {

	public void gameType(String type, Scanner userInput) throws FileNotFoundException, IOException, StandardException {
		try {
			if (type.toLowerCase().equals("console")) {
				Console console = new Console();
				console.homeMenu(userInput);
				// consoleType(userInput);
			}
			else if (type.toLowerCase().equals("gui")) {
				Gui gui = new Gui();
				gui.mainMenu();
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}