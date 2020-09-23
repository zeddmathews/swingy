package swingy.util;

import swingy.model.enemies.tiers.*;
import swingy.controller.EnemyController;
import swingy.exception.StandardException;

public abstract class EnemyCreator {
	public static EnemyController newCharacter(String heroName, String heroClass, int heroLevel, int heroExp, String[] heroArtifacts) throws StandardException {
		if (heroClass.toLowerCase().equals("dwarf")) {
			return new Tier1(heroName);
		}
		else if (heroClass.toLowerCase().equals("elf")) {
			return new Tier2(heroName);
		}
		else if (heroClass.toLowerCase().equals("knight")) {
			return new Tier3(heroName);
		}
		else if (heroClass.toLowerCase().equals("mage")) {
			return new Boss(heroName);
		}
		else {
			throw new StandardException("Invalid class name");
		}
	}
}