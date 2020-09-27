package swingy.model.enemies.tiers;

import java.util.Random;

import swingy.controller.EnemyController;
import swingy.model.enemies.BaseEnemy;

public class Tier1 extends BaseEnemy implements EnemyController {
	public Tier1(String enemyTier, int heroLevel) {
		super(enemyTier, heroLevel);
	}

	public int expDropped() {
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
		return (0);
	}
	@Override
	public String[] enemyData() {
		String[] eData = {};
		return (eData);
	}
}
