package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.enums.Direction;

import java.util.List;

public class Coordinates {

    private final Point x;
    private final Point y;
    private Direction direction;
    private final List<Obstacle> obstacles;

    public Coordinates(Point x, Point y, Direction direction, List<Obstacle> obstacles) {
        this.x = x;
        this.y = y;
        setDirection(direction);
        this.obstacles = obstacles;
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

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveForward() {
        if(direction == Direction.EAST){
            x.setLocation(x.getForwardLocation());
        }
        if(direction == Direction.NORTH){
            y.setLocation(y.getForwardLocation());
        }
    }
}
