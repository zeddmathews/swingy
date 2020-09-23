package swingy.model.enemies.tiers;

import swingy.controller.EnemyController;
import swingy.model.enemies.BaseEnemy;

public class Tier1 extends BaseEnemy implements EnemyController {
	public Tier1(String enemyTier) {
		super(enemyTier);
	}

	public String expDropped() {
		return ("");
	}
}
