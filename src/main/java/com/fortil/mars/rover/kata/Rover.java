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
        if(command == 'F'){
            getCoordinates().moveForward();
        }
        if(command == 'B'){
            getCoordinates().moveBackward();
        }
        if(command == 'L'){
            getCoordinates().goToLeft();
        }
        if(command == 'R'){
            getCoordinates().goToRight();
        }
    }
}
