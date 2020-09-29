package swingy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import swingy.controller.EnemyController;
import swingy.exception.StandardException;
import swingy.util.EnemyCreator;

public class EnemyHandler {
	public static ArrayList<EnemyController> enemyHandler(int heroLevel) throws StandardException {
		ArrayList<EnemyController> enemyList = new ArrayList<EnemyController>();
		Random random = new Random();
		int numberOfEnemies;
		int min;
		int max;
		int enemyTier;
		if (heroLevel > 0 && heroLevel <= 3) {
			min = 3;
			max = 6;
			numberOfEnemies = random.nextInt(max - min + 1) + min;
			for (int i = 0; i < numberOfEnemies; i++) {
				enemyTier = random.nextInt(2 - 1 + 1) + 1;
				if (enemyTier == 1) {
					enemyList.add(EnemyCreator.newCharacter("tier1", heroLevel));
				}
				else if (enemyTier == 2) {
					enemyList.add(EnemyCreator.newCharacter("tier2", heroLevel));
				}
			}
		}
		else if (heroLevel > 3 && heroLevel <=6) {
			min = 6;
			max = 12;
			numberOfEnemies = random.nextInt(max - min + 1) + min;
			for (int i = 0; i < numberOfEnemies; i++) {
				enemyTier = random.nextInt(3 - 2 + 1) + 2;
				if (enemyTier == 2) {
					enemyList.add(EnemyCreator.newCharacter("tier2", heroLevel));
				}
				else if (enemyTier == 3) {
					enemyList.add(EnemyCreator.newCharacter("tier3", heroLevel));
				}
			}
		}
		else if (heroLevel > 6 && heroLevel < 10) {
			min = 12;
			max = 24;
			numberOfEnemies = random.nextInt(max - min + 1) + min;
			for (int i = 0; i < numberOfEnemies; i++) {
				enemyTier = random.nextInt(4 - 3 + 1) + 3;
				if (enemyTier == 3) {
					enemyList.add(EnemyCreator.newCharacter("tier3", heroLevel));
				}
				else if (enemyTier == 4) {
					enemyList.add(EnemyCreator.newCharacter("boss", heroLevel));
				}
			}
		}
		return (enemyList);
	}

	public static HashMap<String, String> enemyPositions(ArrayList<EnemyController> enemyList, int mapLimit, int heroX, int heroY) {
		HashMap<String, String> enemyPositions = new HashMap<>();
		Random random = new Random();
		int enemyX;
		int enemyY;
		String enemyHp = null;
		for (EnemyController enemyController : enemyList) {
			enemyX = random.nextInt(mapLimit);
			enemyY = random.nextInt(mapLimit);
			enemyHp = enemyController.enemyData()[2];
			if (enemyX == heroX) {
				while (enemyX == heroX) {
					enemyX = random.nextInt(mapLimit);
				}
			}
			if (enemyY == heroY) {
				while (enemyY == heroY) {
					enemyY = random.nextInt(mapLimit);
				}
			}
			enemyPositions.put(enemyController.enemyData()[0], Integer.toString(enemyX) + " " + Integer.toString(enemyY) + " " + enemyHp);
		}
		return (enemyPositions);
	}
}
