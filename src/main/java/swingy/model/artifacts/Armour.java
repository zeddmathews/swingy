package swingy.model.artifacts;

import java.util.Random;

public class Armour extends Artifacts {
	public Armour(String type, int stats, int heroLevel) {
		super(type, affectedStat, stats, heroLevel);
	}

	public int generateStats(int heroLevel) {
		int statChange;
		Random rand = new Random();
		int upperbound = 2 * heroLevel;
		statChange = rand.nextInt(upperbound);
		return statChange;
	}
}

//armour, weapon, weapontype