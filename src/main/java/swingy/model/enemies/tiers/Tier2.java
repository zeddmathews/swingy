package swingy.model.enemies.tiers;

import java.util.Random;

import swingy.controller.EnemyController;
import swingy.model.enemies.BaseEnemy;

public class Tier2 extends BaseEnemy implements EnemyController {
	public Tier2(String enemyTier, int heroLevel) {
		super(enemyTier, heroLevel);
	}

	public int expDropped() {
		return (0);
	}

	public boolean artifactDropped() {
		int chance = this.artifactChance(this.enemyTier);
		Random r = new Random();
		boolean dropped = false;
		for (int i = 0; i < chance; i++) {
			if (chance > r.nextInt() * 100) {
				System.out.println("Item with " + chance + " chance is dropped");
				dropped = true;
				break;
			}
		}
		if (dropped == false) {
			System.out.println("Dropping default item");
		}
		return (dropped);
	}

	@Override
	public String[] enemyData() {
		String[] eData = {};
		return (eData);
	}
}
