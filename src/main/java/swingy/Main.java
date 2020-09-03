package swingy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import swingy.args.ArgsHandler;
import swingy.exception.StandardException;
import swingy.view.WindowManager;

public class Main {
	static Scanner userInput;
	static ArgsHandler argsHandler = new ArgsHandler();
	static WindowManager windowManager = new WindowManager();
	public static void main(String[] args) throws StandardException, FileNotFoundException, IOException {
		// formula = (level - 1) * 5 + 10 - (level % 2)
			argsHandler.filterArgs(args);
			userInput = new Scanner(System.in);
			windowManager.gameType(args[0], userInput);
			int formula = (7 - 1) * 5 + 10 - (7 % 2);
			System.out.println(formula + "x" + formula);
			System.out.println("kfsdghfdk");
	}
}