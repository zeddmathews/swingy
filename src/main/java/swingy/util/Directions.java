package swingy.util;

import swingy.exception.StandardException;

public class Directions {
	enum directions {
		north,
		east,
		south,
		west
	}

	String currentDirection;
	String inputDirection;
	public Directions(String currentDirection, String inputDirection) {
		this.currentDirection = currentDirection;
		this.inputDirection = inputDirection;
	}

	// this is a) incomplete and b) probably pointless
	public String changeDirection(String currentDirection, String inputDirection) throws StandardException {
		for (directions dir : directions.values()) {
			if (inputDirection.toLowerCase().equals(dir.toString())) {
				System.out.println("found direction");
				return (inputDirection);
			}
		}
		throw new StandardException("Invalid direction passed");
	}
}