package swingy.model.enemies.tiers;

import swingy.controller.EnemyController;
import swingy.model.enemies.BaseEnemy;

public class Tier2 extends BaseEnemy implements EnemyController {
	public Tier2(String enemyTier) {
		super(enemyTier);
	}

	public String expDropped() {
		return ("");
	}
}
