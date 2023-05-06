package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.enums.Direction;
import com.fortil.mars.rover.kata.exceptions.LocationException;
import com.fortil.mars.rover.kata.exceptions.UnknownCommandException;
import org.junit.jupiter.api.Assertions;
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
    void receive_single_command_should_move_forward_when_command_is_F() throws UnknownCommandException {
        int expected = y.getLocation() - 1;
        rover.receiveSingleCommand('F');
        assertThat(rover.getCoordinates().getY().getLocation()).isEqualTo(expected);
    }

    @Test
    void receive_single_command_should_move_backward_when_command_is_B() throws UnknownCommandException {
        int expected = y.getLocation() + 1;
        rover.receiveSingleCommand('B');
        assertThat(rover.getCoordinates().getY().getLocation()).isEqualTo(expected);
    }

    @Test
    void receive_single_command_should_turn_left_when_command_is_L() throws UnknownCommandException {
        rover.receiveSingleCommand('L');
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void receive_single_command_should_turn_right_when_command_is_R() throws UnknownCommandException {
        rover.receiveSingleCommand('R');
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void receive_single_command_should_ign_case() throws UnknownCommandException {
        rover.receiveSingleCommand('l');
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void receive_single_command_should_throw_UnknownCommandException_when_command_is_unknown() {
        Assertions.assertThrows(UnknownCommandException.class, () -> {
            rover.receiveSingleCommand('Z');
        });
    }

    @Test
    void rover_should_be_able_to_receive_multiple_commands() throws UnknownCommandException {
        int xExpected = x.getLocation() + 1;
        rover.receiveCommands("FLFRF");
        assertThat(rover.getCoordinates().getX().getLocation()).isEqualTo(xExpected);
        assertThat(rover.getCoordinates().getY().getLocation()).isEqualTo(y.getMaxLocation());
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void receiveCommands_should_go_from_one_edge_of_the_grid_to_other() throws UnknownCommandException {
        int expected = x.getMaxLocation() + x.getLocation() - 2;
        rover.receiveCommands("RFFF");
        assertThat(rover.getCoordinates().getX().getLocation()).isEqualTo(expected);
    }

    @Test
    void receiveCommands_should_stop_when_obstacle_is_found() throws UnknownCommandException {
        int expected = x.getLocation() + 1;
        rover.getCoordinates().setObstacles(List.of(new Obstacle(expected + 1, y.getLocation())));
        rover.getCoordinates().setDirection(Direction.EAST);
        rover.receiveCommands("FFFRF");
        assertThat(rover.getCoordinates().getX().getLocation()).isEqualTo(expected);
        assertThat(rover.getCoordinates().getDirection()).isEqualTo(Direction.EAST);
    }
}
