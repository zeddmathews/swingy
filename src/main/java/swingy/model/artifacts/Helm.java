package swingy.model.artifacts;

// import javax.validation.constraints.NotNull;

import swingy.controller.ArtifactController;

public class Helm extends Artifacts implements ArtifactController {
	public Helm(String type, int heroLevel) {
		super(type, heroLevel);
		this.type = "helm";
	}
	// @Override

	//based on current character level
	//assign to character db
}