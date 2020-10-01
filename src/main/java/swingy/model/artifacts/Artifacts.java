package swingy.model.artifacts;

import java.util.Random;
import javax.validation.constraints.*;

public abstract class Artifacts {
	@NotNull(message = "Artifact type cannot be null")
	@Size(min = 4, max = 6, message = "Artifact type length should not be less than 4 or greater than 6")
	String type;

	@Min(value = 1, message = "Should not be less than 1")
	@Max(value = 10, message = "Should not be greater than 10")
	int heroLevel;

	@Min(value = 1, message = "Should not be less than 1")
	@Max(value = 20, message = "Should not be greater than 20")
	int stats;
	public Artifacts(String type, int heroLevel) {
		this.type = type;
		this.heroLevel = heroLevel;
		this.stats = generateStats(this.heroLevel);
	}

	public int generateStats(int heroLevel) {
		int statChange;
		Random rand = new Random();
		int upperbound = 2 * heroLevel;
		statChange = rand.nextInt(upperbound - 1 + 1) + 1;
		return statChange;
	}

	public String[] artifactData() {
		String[] artifactData = {
			this.type,
			Integer.toString(this.heroLevel),
			Integer.toString(this.stats)
		};
		return artifactData;
	}
}