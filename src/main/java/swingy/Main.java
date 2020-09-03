package swingy;

import src.main.java.swingy.args.ArgsHandler;
import src.main.java.swingy.exception.StandardException;

public class Main {
	static ArgsHandler argsHandler = new ArgsHandler();
	public static void main(String[] args) throws StandardException {
		// formula = (level - 1) * 5 + 10 - (level % 2)
		try {
			argsHandler.filterArgs(args);
			int formula = (7 - 1) * 5 + 10 - (7 % 2);
			System.out.println(formula + "x" + formula);
			System.out.println("kfsdghfdk");
		}
		catch (StandardException e) {
			System.out.println(e.getMessage());
		}
	}
}