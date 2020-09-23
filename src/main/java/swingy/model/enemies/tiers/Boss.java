package swingy.model.enemies.tiers;

import swingy.controller.EnemyController;
import swingy.model.enemies.BaseEnemy;

public class Boss extends BaseEnemy implements EnemyController {
	public Boss(String enemyTier) {
		super(enemyTier);
	}

	public String expDropped() {
		return ("");
	}
}
