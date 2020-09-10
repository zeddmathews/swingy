package swingy.model.artifacts;

import java.util.Random;

import swingy.controller.ArtifactController;

public class Weapon extends Artifacts implements ArtifactController {
	public Weapon(String type, int stats, int heroLevel) {
		super(type, stats, heroLevel);
	}

	public int generateStats(int heroLevel) {
		int statChange;
		Random rand = new Random();
		int upperbound = 2 * heroLevel;
		statChange = rand.nextInt(upperbound);
		return statChange;
	}
}