package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.enums.Direction;
import com.fortil.mars.rover.kata.exceptions.LocationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RoverUT {

    private Rover rover;
    private Coordinates roverCoordinates;

    private final Direction direction = Direction.SOUTH;
    private Point x;
    private Point y;
    private List<Obstacle> obstacles;

    @BeforeEach
    void setUp() throws LocationException {
        x = new Point(2, 11);
        y = new Point(1, 11);
        obstacles = new ArrayList<Obstacle>();
        roverCoordinates = new Coordinates(x, y, direction, obstacles);
        rover = new Rover(roverCoordinates);
    }

    @Test
    void new_instance_should_set_rover_coordinates_and_direction() {
        assertThat(rover.getCoordinates()).usingRecursiveComparison().isEqualTo(roverCoordinates);
    }

    @Test
    void receive_single_command_should_move_forward_when_command_is_F() {
        int expected = y.getLocation() - 1;
        rover.receiveSingleCommand('F');
        assertThat(rover.getCoordinates().getY().getLocation()).isEqualTo(expected);
    }

    @Test
    void receive_single_command_should_move_backward_when_command_is_B() {
        int expected = y.getLocation() + 1;
        rover.receiveSingleCommand('B');
        assertThat(rover.getCoordinates().getY().getLocation()).isEqualTo(expected);
    }

    @Test
    void receive_single_command_should_turn_left_when_command_is_L() {
        rover.receiveSingleCommand('L');
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void receive_single_command_should_turn_right_when_command_is_R() {
        rover.receiveSingleCommand('R');
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void receive_single_command_should_ign_case() {
        rover.receiveSingleCommand('l');
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
    }
}
