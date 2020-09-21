package swingy.model.artifacts;

// import javax.validation.constraints.NotNull;

public abstract class Artifacts {
	String type;
	int stats;
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