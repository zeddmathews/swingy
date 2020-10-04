package swingy.view.gui;

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui {
	Scanner userInput;
	protected JFrame frame;
	protected JPanel mainMenuPanel;
	protected JButton newGameButton;
	protected JButton loadGameButton;
	protected JButton switchModeButton;
	protected JButton quitGameButton;

	private void initUI() {
		frame = new JFrame();
		frame.setTitle("Swingy");
		frame.setSize(1280, 720); // width, height
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initMenu() {
		newGameButton = new JButton("New game");
		loadGameButton = new JButton("Load game");
		switchModeButton = new JButton("Switch mode");
		quitGameButton = new JButton("Quit game");
		newGameButton.setBounds(100, 50, 100, 40);
		loadGameButton.setBounds(100, 100, 100, 40); // x, y, width, height
		switchModeButton.setBounds(100, 150, 100, 40);
		quitGameButton.setBounds(100, 200, 100, 40);
	}

	public void mainMenu() {
		initUI();
		initMenu();

		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField jTextField = new JTextField();
				jTextField.setText("stuff");
			}

		});

		frame.add(newGameButton);
		frame.add(loadGameButton);
		frame.add(switchModeButton);
		frame.add(quitGameButton);
		frame.setLayout(new GridLayout(4, 1));
		frame.setVisible(true);
	}
}