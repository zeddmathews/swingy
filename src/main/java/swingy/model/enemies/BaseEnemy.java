package swingy.model.enemies;

import java.util.Random;

import javax.validation.constraints.*;

public abstract class BaseEnemy {
	@NotNull(message = "Enemy tier cannot be null")
	@Size(min = 4, max = 5, message = "The enemy tier is reall short come now (4-5)")
	protected String enemyTier;

	@Min(value = 1, message = "Should not be less than 1")
	@Max(value = 10, message = "Should not be greater than 10")
	protected int heroLevel;

	public BaseEnemy(String enemyTier, int heroLevel) {
		this.enemyTier = enemyTier;
		this.heroLevel = heroLevel;
	}

	public int artifactChance(String enemyTier) {
		int artifactDropChance = 0;
		if (enemyTier.equals("tier1")) {
			artifactDropChance = 10;
		}
		else if (enemyTier.equals("tier2")) {
			artifactDropChance = 20;
		}
		else if (enemyTier.equals("tier3")) {
			artifactDropChance = 30;
		}
		else if (enemyTier.equals("boss")) {
			artifactDropChance = 50;
		}
		return (artifactDropChance);
	}

	public String[] enemyData() {
		Random random = new Random();
		int attack = 0;
		if (this.enemyTier.equals("tier1")) {
			attack = 1;
		}
		else if (this.enemyTier.equals("tier2")) {
			attack = 2;
		}
		else if (this.enemyTier.equals("tier3")) {
			attack = 3;
		}
		else if (this.enemyTier.equals("boss")) {
			attack = 5;
		}
		String[] eData = {
			this.enemyTier + Integer.toString(random.nextInt(5887456 - 4857445 + 1) + 4857445), //name
			Integer.toString(attack),
			"30"
		};
		return (eData);
	}

	public String generateArtifact(boolean dropped) {
		String artifactDropped = null;
		String[] artifacts = {
			"armour",
			"helm",
			"weapon"
		};
		if (dropped == true) {
			Random random = new Random();
			artifactDropped = artifacts[random.nextInt(3)];
		}
		else {
			artifactDropped = "fail";
		}
		return (artifactDropped);
	}
}
