package swingy.util;

import swingy.model.artifacts.*;
import swingy.controller.ArtifactController;

public abstract class ArtifactCreator {
	public static ArtifactController newArtifact(String type, int heroLevel) {
		if (type.toLowerCase().equals("helm")) {
			return new Helm(type, heroLevel);
		}
		else if (type.toLowerCase().equals("armour")) {
			return new Armour(type, heroLevel);
		}
		else if (type.toLowerCase().equals("weapon")) {
			return new Weapon(type, heroLevel);
		}
		else {
			return null;
		}
	}
}