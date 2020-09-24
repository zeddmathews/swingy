package swingy.util;

import swingy.model.enemies.tiers.*;
import swingy.controller.EnemyController;
import swingy.exception.StandardException;

public abstract class EnemyCreator {
	public static EnemyController newCharacter(String enemyTier) throws StandardException {
		if (enemyTier.toLowerCase().equals("tier1")) {
			return new Tier1(enemyTier);
		}
		else if (enemyTier.toLowerCase().equals("tier2")) {
			return new Tier2(enemyTier);
		}
		else if (enemyTier.toLowerCase().equals("tier3")) {
			return new Tier3(enemyTier);
		}
		else if (enemyTier.toLowerCase().equals("boss")) {
			return new Boss(enemyTier);
		}
		else {
			throw new StandardException("Invalid class name");
		}
	}
}