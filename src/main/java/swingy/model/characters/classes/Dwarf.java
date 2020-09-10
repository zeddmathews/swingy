package swingy.model.characters.classes;

import swingy.controller.CharacterController;
import swingy.model.characters.BaseHero;

public class Dwarf extends BaseHero implements CharacterController {
	public Dwarf(String heroName, String heroClass) {
		super(heroName, heroClass);
	}

	public String defaultStats() {
		return ("");
	}


	//tanky boi
}