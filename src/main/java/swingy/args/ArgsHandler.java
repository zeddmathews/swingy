package swingy.args;

import swingy.exception.StandardException;

public class ArgsHandler {
	public void filterArgs(String[] args) throws StandardException {
		try {
			// System.out.println(args.length);
			if (args.length != 1) {
				throw new StandardException("Invalid number of arguments passed");
			}
			if (args[0].toLowerCase() != "console" && args[0].toLowerCase() != "gui") {
				throw new StandardException(args[0] + " is not a valid argument");
			}
		}
		catch (StandardException e){
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}
}