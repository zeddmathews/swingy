package swingy.args;

import java.io.FileNotFoundException;

import javax.swing.*;

import swingy.exception.StandardException;

public class ArgsHandler {
	public void filterArgs(String[] args) throws StandardException, FileNotFoundException {
		try {
			if (args.length != 1) {
				throw new StandardException("Invalid number of arguments passed");
			}
			String command = args[0].toLowerCase();
			if (!command.equals("console") && !command.equals("gui")){
				throw new StandardException(args[0] + " is not a valid argument");
			}
		}
		catch (StandardException e){
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}
}