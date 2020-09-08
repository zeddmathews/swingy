package swingy.util;

import swingy.model.characters.*;
import swingy.controller.CharacterController;

public abstract class CharacterCreator {
	public static CharacterController newCharacter() {
		return new Dwarf();
	}
}