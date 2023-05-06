package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.exceptions.LocationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CoordinatesUT {

    private Coordinates coordinates;
    private Point x;
    private Point y;

    @BeforeEach
    void setUp() throws LocationException {
        x = new Point(2, 11);
        y = new Point(3, 11);
        coordinates = new Coordinates(x, y);
    }

    @Test
    void new_instance_should_set_x_and_y_params(){
        assertThat(coordinates.getX()).usingRecursiveComparison().isEqualTo(x);
        assertThat(coordinates.getY()).usingRecursiveComparison().isEqualTo(y);
    }
}
