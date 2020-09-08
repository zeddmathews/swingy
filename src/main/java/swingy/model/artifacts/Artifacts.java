package swingy.model.artifacts;

public abstract class Artifacts {
	String type;
	String heroCLass;
	int stats;
	int heroLevel;

	public Artifacts(String type, String heroCLass, int stats, int heroLevel) {
		this.type = type;
		this.stats = stats;
		this.heroLevel = heroLevel;
		this.heroCLass = heroCLass;
	}

	public String[] artifactData() {
		String[] artifactData = {
			this.type,
			Integer.toString(this.stats),
			Integer.toString(this.heroLevel),
		};
		return artifactData;
	}
}