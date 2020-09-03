package swingy.args;

import java.io.FileNotFoundException;

import javax.swing.*;

import swingy.exception.StandardException;
import swingy.view.WindowManager;

public class ArgsHandler {
	public void filterArgs(String[] args) throws StandardException, FileNotFoundException {
		try {
			if (args.length != 1) {
				throw new StandardException("Invalid number of arguments passed");
			}
			String command = args[0].toLowerCase();
			WindowManager windowManager;
			if (command.equals("console")) {
				windowManager = new WindowManager();
				windowManager.consoleWindow();
			}
			else if (command.equals("gui")) {
				windowManager = new WindowManager();
				windowManager.guiWindow();
			}
			else if (!command.equals("console") && !command.equals("gui")){
				throw new StandardException(args[0] + " is not a valid argument");
			}
			else {
				JFrame jFrame = new JFrame();
				JButton jButton = new JButton();
				jButton.setBounds(130, 100, 100, 50); //x, y, width, height
				jFrame.add(jButton);
				jFrame.setSize(400, 500);
				jFrame.setLayout(null); //no layout managers
				jFrame.setVisible(true);
			}
		}
		catch (StandardException e){
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}
}