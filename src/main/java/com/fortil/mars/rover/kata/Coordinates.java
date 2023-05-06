package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.enums.Direction;

public class Coordinates {

    private final Point x;
    private final Point y;
    private final Direction direction;

    public Coordinates(Point x, Point y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Point getX() {
        return x;
    }

    public Point getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
