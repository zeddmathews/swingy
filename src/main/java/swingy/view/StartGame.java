package swingy.view;

public class StartGame {
	// formula = (level - 1) * 5 + 10 - (level % 2)
	// int formula = (7 - 1) * 5 + 10 - (7 % 2);
	protected String gameMode;
	protected int level;
	protected final int formula = (level - 1) * 5 + 10 - (level % 2);
	public StartGame (String gameMode, int heroLevel) {
		this.gameMode = gameMode;
	}

	public void renderMap() {
		System.out.println(formula + "x" + formula);
	}
}