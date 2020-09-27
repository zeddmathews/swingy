package swingy.model.enemies.tiers;

import swingy.controller.EnemyController;
import swingy.model.enemies.BaseEnemy;

public class Boss extends BaseEnemy implements EnemyController {
	public Boss(String enemyTier, int heroLevel) {
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
