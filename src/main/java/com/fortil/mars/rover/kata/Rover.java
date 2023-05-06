package com.fortil.mars.rover.kata;

public class Rover {

    private final Coordinates coordinates;
    public Rover(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void receiveSingleCommand(char command) {
        switch (Character.toUpperCase(command)){
            case 'F' -> getCoordinates().moveForward();
            case 'B' -> getCoordinates().moveBackward();
            case 'R' -> getCoordinates().goToRight();
            case 'L' -> getCoordinates().goToLeft();
        }
    }
}
