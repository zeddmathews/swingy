package swingy.util;

import swingy.model.artifacts.*;
import swingy.controller.ArtifactController;

public abstract class ArtifactCreator {
	public static ArtifactController newArtifact(String type, String affectedStat, int stats, int heroLevel) {
		if (type.toLowerCase().equals("helm")) {
			return new Helm(type, affectedStat, stats, heroLevel);
		}
		else if (type.toLowerCase().equals("armour")) {
			return new Armour(type, affectedStat, stats, heroLevel);
		}
		else if (type.toLowerCase().equals("weapon")) {
			return new Weapon(type, affectedStat, stats, heroLevel);
		}
		else {
			return null;
		}
	}
}