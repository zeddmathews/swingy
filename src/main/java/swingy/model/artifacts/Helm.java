package swingy.model.artifacts;

import swingy.controller.ArtifactController;

public class Helm extends Artifacts implements ArtifactController {
	public Helm(String type, String affectedStat, int stats, int heroLevel) {
		super(type, affectedStat, stats, heroLevel);
		this.type = "helm";
	}

	public int generateStats(String affectedStat, int heroLevel) {
		return 0;
	}
	//based on current character level
	//assign to character db
}