package swingy.model.characters.classes;

import swingy.controller.CharacterController;
import swingy.model.characters.BaseHero;

public class Mage extends BaseHero implements CharacterController {
	public Mage(String heroName, String heroClass) {
		super(heroName, heroClass);
	}

	public String defaultStats() {
		return ("");
	}
	// dps for years, no hp
}