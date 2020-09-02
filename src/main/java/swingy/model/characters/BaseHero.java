package src.main.java.swingy.model.characters;

public class BaseHero {
	String heroName;
	String heroClass;
	int heroLevel;
	int heroExp;
	String[] heroAtrifacts;

	public BaseHero(String heroName, String heroClass) {
		this.heroName = heroName;
		this.heroClass = heroClass;
	}
}