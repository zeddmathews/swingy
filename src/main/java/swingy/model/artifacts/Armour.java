package swingy.model.artifacts;

public class Armour extends Artifacts {
	public Armour(String type, String affectedStat, int stats, int heroLevel) {
		super(type, affectedStat, stats, heroLevel);
	}

	public int generateStats(String affectedStat, int heroLevel) {
		return 0;
	}
}

//armour, weapon, weapontype