package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.enums.Direction;
import com.fortil.mars.rover.kata.exceptions.LocationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CoordinatesUT {

    private Coordinates coordinates;
    private Point x;
    private Point y;

    private final Direction direction = Direction.SOUTH;
    private List<Obstacle> obstacles;

    @BeforeEach
    void setUp() throws LocationException {
        x = new Point(2, 11);
        y = new Point(3, 11);
        obstacles = Arrays.asList(new Obstacle(7, 8), new Obstacle(5, 10));
        coordinates = new Coordinates(x, y, direction, obstacles);
    }

    @Test
    void new_instance_should_set_x_and_y_params(){
        assertThat(coordinates.getX()).usingRecursiveComparison().isEqualTo(x);
        assertThat(coordinates.getY()).usingRecursiveComparison().isEqualTo(y);
    }

    @Test
    void new_instance_should_set_direction_param(){
        assertThat(coordinates.getDirection()).isEqualTo(direction);
    }

    @Test
    void new_instance_should_set_obstacles_param(){
        assertThat(coordinates.getObstacles()).hasSameElementsAs(obstacles);
    }

    @Test
    void move_forward_should_increase_x_when_direction_is_east() throws LocationException {
        Point expected = new Point(x.getLocation() + 1, x.getMaxLocation());
        coordinates.setDirection(Direction.EAST);
        coordinates.moveForward();
        assertThat(coordinates.getX()).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void move_forward_should_increase_y_when_direction_is_north() throws LocationException {
        Point expected = new Point(y.getLocation() + 1, y.getMaxLocation());
        coordinates.setDirection(Direction.NORTH);
        coordinates.moveForward();
        assertThat(coordinates.getY()).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void move_forward_should_decrease_x_when_direction_is_west() throws LocationException {
        Point expected = new Point(x.getLocation() - 1, x.getMaxLocation());
        coordinates.setDirection(Direction.WEST);
        coordinates.moveForward();
        assertThat(coordinates.getX()).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void move_forward_should_decrease_y_when_direction_is_south() throws LocationException {
        Point expected = new Point(y.getLocation() - 1, y.getMaxLocation());
        coordinates.setDirection(Direction.SOUTH);
        coordinates.moveForward();
        assertThat(coordinates.getY()).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    public void move_forward_should_not_change_location_when_obstacle_is_found() {
        int expected = x.getLocation();
        coordinates.setDirection(Direction.EAST);
        coordinates.setObstacles(List.of(new Obstacle(x.getLocation() + 1, y.getLocation())));
        coordinates.move(coordinates.getDirection());
        assertThat(coordinates.getX().getLocation()).isEqualTo(expected);
    }

    @Test
    public void move_backward_should_not_change_location_when_obstacle_is_found() {
        int expected = x.getLocation();
        coordinates.setDirection(Direction.WEST);
        coordinates.setObstacles(List.of(new Obstacle(x.getLocation() - 1, y.getLocation())));
        coordinates.move(coordinates.getDirection());
        assertThat(coordinates.getX().getLocation()).isEqualTo(expected);
    }

    @Test
    void move_backward_should_decrease_x_when_direction_is_east() throws LocationException {
        Point expected = new Point(x.getLocation() - 1, x.getMaxLocation());
        coordinates.setDirection(Direction.EAST);
        coordinates.moveBackward();
        assertThat(coordinates.getX()).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void move_backward_should_decrease_y_when_direction_is_north() throws LocationException {
        Point expected = new Point(y.getLocation() - 1, y.getMaxLocation());
        coordinates.setDirection(Direction.NORTH);
        coordinates.moveBackward();
        assertThat(coordinates.getY()).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void move_backward_should_increase_x_when_direction_is_west() throws LocationException {
        Point expected = new Point(x.getLocation() + 1, x.getMaxLocation());
        coordinates.setDirection(Direction.WEST);
        coordinates.moveBackward();
        assertThat(coordinates.getX()).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void move_backward_should_increase_y_when_direction_is_south() throws LocationException {
        Point expected = new Point(y.getLocation() + 1, y.getMaxLocation());
        coordinates.setDirection(Direction.SOUTH);
        coordinates.moveBackward();
        assertThat(coordinates.getY()).usingRecursiveComparison().isEqualTo(expected);
    }

}
