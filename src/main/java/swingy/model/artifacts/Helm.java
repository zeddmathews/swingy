package swingy.model.artifacts;

import swingy.controller.ArtifactController;

public class Helm extends Artifacts implements ArtifactController {
	public Helm(String type, int stats, int heroLevel) {
		super(type, stats, heroLevel);
		this.type = "helm";
	}

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