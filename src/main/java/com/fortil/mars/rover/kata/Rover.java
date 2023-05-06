package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.exceptions.UnknownCommandException;

public class Rover {

    private final Coordinates coordinates;
    public Rover(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void receiveSingleCommand(char command) throws UnknownCommandException {
        switch (Character.toUpperCase(command)){
            case 'F' -> getCoordinates().moveForward();
            case 'B' -> getCoordinates().moveBackward();
            case 'R' -> getCoordinates().goToRight();
            case 'L' -> getCoordinates().goToLeft();
            default -> throw new UnknownCommandException("Unknown command " + command);
        }
    }
}
