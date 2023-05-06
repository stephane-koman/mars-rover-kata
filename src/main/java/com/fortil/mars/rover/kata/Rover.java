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

    public boolean receiveSingleCommand(char command) throws UnknownCommandException {
        switch (Character.toUpperCase(command)){
            case 'F' -> {
                return getCoordinates().moveForward();
            }
            case 'B' -> {
                return getCoordinates().moveBackward();
            }
            case 'R' -> {
                getCoordinates().turnToRight();
                return true;
            }
            case 'L' -> {
                getCoordinates().turnToLeft();
                return true;
            }
            default -> throw new UnknownCommandException("Unknown command " + command);
        }
    }

    public void receiveCommands(String commands) throws UnknownCommandException {
        for (char command: commands.toCharArray()) {
            if(!receiveSingleCommand(command)) break;
        }
    }

    public String getPosition() {
        return getCoordinates().toString();
    }
}
