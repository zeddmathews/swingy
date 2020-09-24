package swingy.model.artifacts;

import javax.validation.constraints.*;

public abstract class Artifacts {
	@NotNull(message = "Artifact type cannot be null")
	@Size(min = 4, max = 6, message = "Artifact type length should not be less than 4 or greater than 6")
	String type;

	@Min(value = 0, message = "Negative value not allowed")
	int stats;

	@Min(value = 1, message = "Should not be less than 1")
	@Max(value = 10, message = "Should not be greater than 10")
	int heroLevel;

	public Artifacts(String type, int stats, int heroLevel) {
		this.type = type;
		this.stats = stats;
		this.heroLevel = heroLevel;
	}

	public abstract int generateStats(int heroLevel);
	public String[] artifactData() {
		String[] artifactData = {
			this.type,
			Integer.toString(this.stats),
			Integer.toString(this.heroLevel),
		};
		return artifactData;
	}
}