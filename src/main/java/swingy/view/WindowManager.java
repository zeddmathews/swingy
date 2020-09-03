package swingy.view;

import java.io.File;
// import java.nio.file.Paths;
// import java.nio.file.Path;
// import java.nio.file.Files;
import java.io.FileNotFoundException;

public class WindowManager {
	public WindowManager() {}

	public void checkSaveData() {
		// try {
			File saveData = new File("heroes.txt");
			// Path path = Paths.getAbsolutePath("heroes.txt");
			System.out.println(saveData);
			System.out.println(saveData.getAbsolutePath());
			// System.out.println(path);
			if (saveData.isFile()) {
				System.out.println("Save data found\nLoading save file");
			}
			else {
				System.out.println("Something went wrong");
			}
		// }
		// catch (FileNotFoundException e) {
		// 	System.out.println(e.getMessage());
		// }
	}

	public void consoleWindow() throws FileNotFoundException {
		boolean running = true;
		checkSaveData();
		while (running) {
			System.out.println("Welcome to Swingy");

		}
	}

	public void guiWindow() throws FileNotFoundException {
		checkSaveData();
	}
}