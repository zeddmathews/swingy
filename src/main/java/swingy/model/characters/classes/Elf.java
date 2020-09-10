package swingy.model.characters.classes;

import swingy.controller.CharacterController;
import swingy.model.characters.BaseHero;

public class Elf extends BaseHero implements CharacterController {
	public Elf(String heroName, String heroClass) {
		super(heroName, heroClass);
	}

	public String defaultStats() {
		return ("");
	}
	// nimble squishy
}