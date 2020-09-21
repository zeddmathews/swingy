package swingy.model.characters.classes;

import swingy.controller.CharacterController;
import swingy.model.characters.BaseHero;

public class Elf extends BaseHero implements CharacterController {
	public Elf(String heroName, String heroClass) {
		super(heroName, heroClass);
	}

	public static String[] defaultStats() {
		String[] arr = {
			"attack 10",
			"defense 10",
			"hp 15",
			"speed 10"
		};
		return (arr);
	}
	// nimble squishy
}