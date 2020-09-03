package swingy.args;

import javax.swing.*;

import swingy.exception.StandardException;

public class ArgsHandler {
	public void filterArgs(String[] args) throws StandardException {
		try {
			// System.out.println(args.length);
			if (args.length != 1) {
				throw new StandardException("Invalid number of arguments passed");
			}
			if (!args[0].toLowerCase().equals("console") && !args[0].toLowerCase().equals("gui")) {
				throw new StandardException(args[0] + " is not a valid argument");
			}
			JFrame jFrame = new JFrame();
			JButton jButton = new JButton();
			jButton.setBounds(130, 100, 100, 50); //x, y, width, height
			jFrame.add(jButton);
			jFrame.setSize(400, 500);
			jFrame.setLayout(null); //no layout managers
			jFrame.setVisible(true);
		}
		catch (StandardException e){
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}
}