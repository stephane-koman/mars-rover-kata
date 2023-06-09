package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.enums.Direction;

import java.util.List;

public class Coordinates {

    private final Point x;
    private final Point y;
    private Direction direction;
    private List<Obstacle> obstacles;
    private boolean obstacleFounded = false;

    public Coordinates(Point x, Point y, Direction direction, List<Obstacle> obstacles) {
        this.x = x;
        this.y = y;
        setDirection(direction);
        setObstacles(obstacles);
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

    public boolean moveForward() {
        return move(direction);
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    private boolean hasObstacle(int xLocation, int yLocation) {
        for (Obstacle obstacle: obstacles) {
            if(obstacle.x() == xLocation && obstacle.y() == yLocation) {
                obstacleFounded = true;
                return true;
            }
        }
        return false;
    }

    public boolean move(Direction newDirection) {
        int xLocation = x.getLocation();
        int yLocation = y.getLocation();

        switch (newDirection) {
            case EAST -> xLocation = x.getForwardLocation();
            case WEST -> xLocation = x.getBackwardLocation();
            case NORTH -> yLocation = y.getForwardLocation();
            case SOUTH -> yLocation = y.getBackwardLocation();
        }

        if(!hasObstacle(xLocation, yLocation)){
            x.setLocation(xLocation);
            y.setLocation(yLocation);
            return true;
        }
        return false;
    }

    public boolean moveBackward() {
        return move(direction.getBackwardDirection());
    }

    public void turnToLeft() {
        changeDirection(-1);
    }

    public void turnToRight() {
        changeDirection(1);
    }

    private void changeDirection(int step) {
        int directionsLength = Direction.values().length;
        int index = (directionsLength + direction.getValue() + step) % directionsLength;
        direction = Direction.values()[index];
    }

    @Override
    public String toString() {
        String status = "";
        if(obstacleFounded) {
            status = " OBSTACLE_FOUND";
        }
        return "X=" + getX().getLocation() + ", Y=" + getY().getLocation() + ", D=" + getDirection().getShortName() + status;
    }
}
