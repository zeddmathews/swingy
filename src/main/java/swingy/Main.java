package swingy;

import java.io.FileNotFoundException;

import swingy.args.ArgsHandler;
import swingy.exception.StandardException;

public class Main {
	static ArgsHandler argsHandler = new ArgsHandler();
	public static void main(String[] args) throws StandardException, FileNotFoundException {
		// formula = (level - 1) * 5 + 10 - (level % 2)
			argsHandler.filterArgs(args);
			int formula = (7 - 1) * 5 + 10 - (7 % 2);
			System.out.println(formula + "x" + formula);
			System.out.println("kfsdghfdk");
	}
}