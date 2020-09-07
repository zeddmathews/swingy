package swingy.model.artifacts;

public class Weapon extends Artifacts {
	public Weapon(String type, String affectedStat, int stats, int heroLevel) {
		super(type, affectedStat, stats, heroLevel);
	}

	public int generateStats(String affectedStat, int heroLevel) {
		return 0;
	}
}