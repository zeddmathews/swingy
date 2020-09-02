package src.main.java.swingy.args;

import src.main.java.swingy.exception.StandardException;

public class ArgsHandler {
	// public static String[] args;

	public void filterArgs(String[] args) throws StandardException {
		try {
			if (args.length != 2) {
				// obviously need to check that
				throw new StandardException("Invalid number of arguments passed");
			}
			if (args[1].toLowerCase() != "console" && args[1].toLowerCase() != "gui") {
				throw new StandardException(args[1] + "is not a valid argument");
			}
		}
		catch (StandardException e){
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}
}