package swingy.model;

import java.util.ArrayList;
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
					enemyList.add(EnemyCreator.newCharacter("tier1"));
				}
				else if (enemyTier == 2) {
					enemyList.add(EnemyCreator.newCharacter("tier2"));
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
					enemyList.add(EnemyCreator.newCharacter("tier2"));
				}
				else if (enemyTier == 3) {
					enemyList.add(EnemyCreator.newCharacter("tier3"));
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
					enemyList.add(EnemyCreator.newCharacter("tier3"));
				}
				else if (enemyTier == 4) {
					enemyList.add(EnemyCreator.newCharacter("boss"));
				}
			}
		}
		return (enemyList);
	}
}
