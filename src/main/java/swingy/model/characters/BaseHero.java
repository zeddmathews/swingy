package swingy.model.characters;

import javax.validation.constraints.*;

public abstract class BaseHero {
	@NotNull(message = "Name cannot be null")
	@Size(min = 2, max = 16, message = "Name length should not be less than 2 or greater than 16")
	String heroName;

	@NotNull(message = "Class cannot be null")
	@Size(min = 2, max = 16, message = "Class length should not be less than 2 or greater than 16")
	String heroClass;

	public BaseHero(String heroName, String heroClass) {
		this.heroName = heroName;
		this.heroClass = heroClass;
	}

	public String heroData() {
		return this.heroName + " " + this.heroClass;
	}
}