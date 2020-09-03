package swingy.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HeroStorage {
	// write hero data to txt file or toss in db we'll see how lazy i am
	static BufferedWriter bW;
	static File txtFile;
	public HeroStorage() {
		try {
			txtFile = new File("heroes.txt");
			if (bW == null) {
				bW = new BufferedWriter(new FileWriter(txtFile));
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// public static void findSaveData
}