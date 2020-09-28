package swingy.model.artifacts;

import java.util.Random;

// import javax.validation.constraints.NotNull;

import swingy.controller.ArtifactController;

public class Weapon extends Artifacts implements ArtifactController {
	public Weapon(String type, int heroLevel) {
		super(type, heroLevel);
	}

	public int generateStats(int heroLevel) {
		int statChange;
		Random rand = new Random();
		int upperbound = 2 * heroLevel;
		statChange = rand.nextInt(upperbound);
		return statChange;
	}
}