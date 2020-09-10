package swingy.model.characters.classes;

import swingy.controller.CharacterController;
import swingy.model.characters.BaseHero;

public class Knight extends BaseHero implements CharacterController {
	public Knight(String heroName, String heroClass) {
		super(heroName, heroClass);
	}

	public String defaultStats() {
		return ("");
	}
	// basic bitch vanilla stats
}