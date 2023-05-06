package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.exceptions.LocationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PointUT {

    Point point;
    private final int location = 3;
    private final int maxLocation = 8;

    @BeforeEach
    void setUp() throws LocationException {
        point = new Point(location, maxLocation);
    }

    @Test
    void new_instance_should_set_location_and_maxLocation_params(){
        assertThat(point.getLocation()).isEqualTo(location);
        assertThat(point.getMaxLocation()).isEqualTo(maxLocation);
    }

    @Test
    void location_less_than_zero_should_throw_LocationException(){
        Assertions.assertThrows(LocationException.class, () -> new Point(-1, maxLocation));
    }

    @Test
    void maxLocation_less_than_zero_should_throw_LocationException(){
        Assertions.assertThrows(LocationException.class, () -> new Point(-1, maxLocation));
    }

    @Test
    void maxLocation_less_than_location_should_throw_LocationException(){
        Assertions.assertThrows(LocationException.class, () -> new Point(location, 1));
    }

    @Test
    void getForwardLocation_should_increase_point_value_by_one(){
        int expected = point.getLocation() + 1;
        assertThat(point.getForwardLocation()).isEqualTo(expected);
    }

    @Test
    void getBackwardLocation_should_decrease_point_value_by_one(){
        int expected = point.getLocation() - 1;
        assertThat(point.getBackwardLocation()).isEqualTo(expected);
    }

    @Test
    public void getForwardLocation_should_set_value_to_zero_if_max_location_is_passed() throws LocationException {
        point = new Point(maxLocation, maxLocation);
        assertThat(point.getForwardLocation()).isZero();
    }
}
