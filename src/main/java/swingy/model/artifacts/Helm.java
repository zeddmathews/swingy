package swingy.model.artifacts;

public class Helm extends Artifacts {
	public Helm(String type, String affectedStat, int stats, int heroLevel) {
		super(type, affectedStat, stats, heroLevel);
	}

	public int generateStats(String affectedStat, int heroLevel) {
		return 0;
	}
	//based on current character level
	//assign to character db
}