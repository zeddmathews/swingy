package swingy.util;

import swingy.model.characters.classes.*;
import swingy.controller.CharacterController;
import swingy.exception.StandardException;

public abstract class CharacterCreator {
	public static CharacterController newCharacter(String heroName, String heroClass, int heroLevel, int heroExp, String[] heroArtifacts) throws StandardException {
		if (heroClass.toLowerCase().equals("dwarf")) {
			return new Dwarf(heroName, heroClass);
		}
		else if (heroClass.toLowerCase().equals("elf")) {
			return new Elf(heroName, heroClass);
		}
		else if (heroClass.toLowerCase().equals("knight")) {
			return new Knight(heroName, heroClass);
		}
		else if (heroClass.toLowerCase().equals("mage")) {
			return new Mage(heroName, heroClass);
		}
		else {
			throw new StandardException("Invalid class name");
		}
	}
}