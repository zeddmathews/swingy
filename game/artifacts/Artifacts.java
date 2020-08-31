package game.artifacts;

public class Artifacts {
	String type;
	String heroClass;
	int stats;
	int minLevel;

	public Artifacts(String type, String heroClass, int stats, int minLevel) {
		this.type = type;
		this.heroClass = heroClass;
		this.stats = stats;
		this.minLevel = minLevel;
	}

	public String[] artifactData () {
		String[] artifactData = {
			this.type,
			this.heroClass,
			Integer.toString(this.stats),
			Integer.toString(this.minLevel)
		};
		return artifactData;
	}
}