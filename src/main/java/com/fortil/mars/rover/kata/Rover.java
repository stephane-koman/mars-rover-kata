package com.fortil.mars.rover.kata;

public class Rover {

    private final Coordinates coordinates;
    public Rover(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
