package swingy.controller;

public interface EnemyController {
	int expDropped();
	String[] enemyData();
	boolean artifactDropped();
	int artifactChance(String enemyTier);
	String generateArtifact(boolean dropped);
}
