package com.fortil.mars.rover.kata;

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
    void setUp(){
        point = new Point(location, maxLocation);
    }

    @Test
    void new_instance_should_set_location_and_maxLocation_params(){
        assertThat(point.getLocation()).isEqualTo(location);
        assertThat(point.getMaxLocation()).isEqualTo(maxLocation);
    }
}
