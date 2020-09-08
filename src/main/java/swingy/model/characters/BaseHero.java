package swingy.model.characters;

public abstract class BaseHero {
	String heroName;
	String heroClass;
	int heroLevel;
	int heroExp;
	String[] heroAtrifacts;

	public BaseHero(String heroName, String heroClass) {
		this.heroName = heroName;
		this.heroClass = heroClass;
	}

	public String heroData() {
		return this.heroName + " " + this.heroClass;
	}
}