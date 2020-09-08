package swingy.util;

public abstract class ArtifactCreator {
	public static ArtifactController newArtifact(String type, String affectedStat, int stats, int heroLevel) {
		return new Helm(type, affectedStat, stats, heroLevel);
	}
}