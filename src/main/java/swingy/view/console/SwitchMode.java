package swingy.view.console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import swingy.exception.StandardException;
import swingy.view.gui.Gui;

public class SwitchMode {
	public static void switchMode(String currentMode, Scanner userInput) throws StandardException, IOException, FileNotFoundException {
		if (currentMode.equals("console")) {
			Gui gui = new Gui();
			gui.mainMenu();
		}
		else if (currentMode.equals("gui")) {
			Console console = new Console();
			console.homeMenu(userInput);
		}
	}
}