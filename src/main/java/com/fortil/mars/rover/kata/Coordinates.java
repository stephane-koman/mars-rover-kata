package com.fortil.mars.rover.kata;

public class Coordinates {

    private final Point x;
    private final Point y;

    public Coordinates(Point x, Point y) {
        this.x = x;
        this.y = y;
    }

    public Point getX() {
        return x;
    }

    public Point getY() {
        return y;
    }
}
