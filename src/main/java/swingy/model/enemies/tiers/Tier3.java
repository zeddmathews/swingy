package swingy.model.enemies.tiers;

import swingy.controller.EnemyController;
import swingy.model.enemies.BaseEnemy;

public class Tier3 extends BaseEnemy implements EnemyController {
	public Tier3(String enemyTier, int heroLevel) {
		super(enemyTier, heroLevel);
	}

	public int expDropped() {
		return (0);
	}
	@Override
	public String[] enemyData() {
		String[] eData = {};
		return (eData);
	}
}