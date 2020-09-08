package swingy.model.artifacts;

public abstract class Artifacts {
	String type;
	String affectedStat;
	int stats;
	int heroLevel;

	public Artifacts(String type, String affectedStat, int stats, int heroLevel) {
		this.type = type;
		this.affectedStat = affectedStat;
		this.stats = stats;
		this.heroLevel = heroLevel;
	}

	public String[] artifactData() {
		String[] artifactData = {
			type,
			affectedStat,
			Integer.toString(stats),
			Integer.toString(heroLevel),
		};
		return artifactData;
	}
}