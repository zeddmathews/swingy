package swingy.util;

import swingy.exception.StandardException;

public class Directions {
	final enum directions {
		North,
		East,
		South,
		West
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
			if (inputDirection.toLowerCase().equals(dir)) {
				System.out.println("found direction");
				return (inputDirection);
			}
		}
		throw new StandardException("Invalid direction passed");
	}
}