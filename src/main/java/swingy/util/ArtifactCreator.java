package swingy.util;

import swingy.model.artifacts.*;
import swingy.controller.ArtifactController;

public abstract class ArtifactCreator {
	public static ArtifactController newArtifact(String type, int stats, int heroLevel) {
		if (type.toLowerCase().equals("helm")) {
			return new Helm(type, stats, heroLevel);
		}
		else if (type.toLowerCase().equals("armour")) {
			return new Armour(type, stats, heroLevel);
		}
		else if (type.toLowerCase().equals("weapon")) {
			return new Weapon(type, stats, heroLevel);
		}
		else {
			return null;
		}
	}
}