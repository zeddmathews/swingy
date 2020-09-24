package swingy.model.enemies;

import javax.validation.constraints.*;

public abstract class BaseEnemy {
	@NotNull(message = "Enemy tier cannot be null")
	@Size(min = 4, max = 5, message = "The enemy tier is reall short come now (4-5)")
	String enemyTier;

	public BaseEnemy(String enemyTier) {
		this.enemyTier = enemyTier;
	}
}
