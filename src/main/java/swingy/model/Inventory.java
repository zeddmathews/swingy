package swingy.model;

public class Inventory {
	int heroLevel;
	int inventorySize;

	public Inventory(int heroLevel, int inventorySize) {
		this.heroLevel = heroLevel;
		this.inventorySize = inventorySize + (heroLevel * 2);
	}
}