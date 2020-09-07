package swingy.model.artifacts;

public abstract class Artifacts {
	String type;
	String affectedStat;
	int stats;

	public Artifacts(String type, String affectedStat, int stats) {
		this.type = type;
		this.affectedStat = affectedStat;
		this.stats = stats;
	}

	public String[] artifactData () {
		String[] artifactData = {
			type,
			affectedStat,
			Integer.toString(stats)
		};
		return artifactData;
	}
}