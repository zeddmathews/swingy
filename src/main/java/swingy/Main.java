package swingy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import swingy.exception.StandardException;
import swingy.util.database.CreateTable;
import swingy.util.database.Database;
import swingy.view.WindowManager;

public class Main {
	static Scanner userInput;
	static WindowManager windowManager = new WindowManager();
	static String[] err;
	public static void main(String[] args) throws StandardException, FileNotFoundException, IOException {
		try {
			if (args.length != 1) {
				throw new StandardException("Invalid number of arguments");
			}
			else if (!args[0].toLowerCase().equals("console") && !args[0].toLowerCase().equals("gui")) {
				throw new StandardException(args[0] + " is not a valid argument");
			}
			else {
				Database.createDB();
				CreateTable.createHeroesTable();
				CreateTable.createInventoryTable();
				userInput = new Scanner(System.in);
				windowManager.gameType(args[0], userInput); // handles game mode to launch
				// System.out.println("kfsdghfdk");
			}
		}
		catch (StandardException se) {
			System.out.println(se.getMessage());
		}
	}
}