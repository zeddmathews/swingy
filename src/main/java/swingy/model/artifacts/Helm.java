package swingy.model.artifacts;

import java.util.Random;

// import javax.validation.constraints.NotNull;

import swingy.controller.ArtifactController;

public class Helm extends Artifacts implements ArtifactController {
	public Helm(String type, int heroLevel) {
		super(type, heroLevel);
		this.type = "helm";
	}
	@Override
	public int generateStats(int heroLevel) {
		int statChange;
		Random rand = new Random();
		int upperbound = 2 * heroLevel;
		statChange = rand.nextInt(upperbound);
		return statChange;
	}
	//based on current character level
	//assign to character db
}