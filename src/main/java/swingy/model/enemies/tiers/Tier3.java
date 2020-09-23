package swingy.model.enemies.tiers;

import swingy.controller.EnemyController;
import swingy.model.enemies.BaseEnemy;

public class Tier3 extends BaseEnemy implements EnemyController {
	public Tier3(String enemyTier) {
		super(enemyTier);
	}

	public String expDropped() {
		return ("");
	}
}