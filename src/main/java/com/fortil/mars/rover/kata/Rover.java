package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.exceptions.UnknownCommandException;

public record Rover(Coordinates coordinates) {

    public boolean receiveSingleCommand(char command) throws UnknownCommandException {
        switch (Character.toUpperCase(command)) {
            case 'F' -> {
                return coordinates().moveForward();
            }
            case 'B' -> {
                return coordinates().moveBackward();
            }
            case 'R' -> {
                coordinates().turnToRight();
                return true;
            }
            case 'L' -> {
                coordinates().turnToLeft();
                return true;
            }
            default -> throw new UnknownCommandException("Unknown command " + command);
        }
    }

    public void receiveCommands(String commands) throws UnknownCommandException {
        for (char command : commands.toCharArray()) {
            if (!receiveSingleCommand(command)) break;
        }
    }

    public String getPosition() {
        return coordinates().toString();
    }
}
