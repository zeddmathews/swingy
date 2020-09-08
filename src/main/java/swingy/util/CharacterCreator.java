package swingy.util;

import swingy.model.characters.*;
import swingy.controller.CharacterController;

public abstract class CharacterCreator {
	public static CharacterController newCharacter(String heroName, String heroClass, int heroLevel, int heroExp, String[] heroArtifacts) throws StandardException {
		if (heroClass.toLowerCase().equals("dwarf")) {
			return new Dwarf();
		}
		else if (heroClass.toLowerCase().equals("elf")) {
			return new Elf();
		}
		else if (heroClass.toLowerCase().equals("knight")) {
			return new Knight();
		}
		else if (heroClass.toLowerCase().equals("mage")) {
			return new Mage();
		}
		else {
			throw new StandardException("Invalid class name");
		}
	}
}