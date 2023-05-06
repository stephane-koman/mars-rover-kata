package com.fortil.mars.rover.kata;

public class Point {

    private final int location;
    private final int maxLocation;

    public Point(int location, int maxLocation) {
        this.location = location;
        this.maxLocation = maxLocation;
    }

    public int getLocation() {
        return location;
    }

    public int getMaxLocation() {
        return maxLocation;
    }
}
