package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.exceptions.LocationException;

import java.text.MessageFormat;

public class Point {

    private int location;
    private final int maxLocation;
    private static final String LOCATION_ERROR_MESSAGE = "parameter cannot be less than";

    public Point(int location, int maxLocation) throws LocationException {
        if(location < 0)
            throw new LocationException(MessageFormat.format("Location {0} ZERO", LOCATION_ERROR_MESSAGE));

        if(maxLocation < 0)
            throw new LocationException(MessageFormat.format("maxLocation {0} ZERO", LOCATION_ERROR_MESSAGE));

        if(maxLocation < location )
            throw new LocationException(MessageFormat.format("maxLocation {0} location parameter", LOCATION_ERROR_MESSAGE));

        this.location = location;
        this.maxLocation = maxLocation;
    }

    public int getLocation() {
        return location;
    }

    public int getMaxLocation() {
        return maxLocation;
    }

    public int getForwardLocation() {
        return (getLocation() + 1) % (getMaxLocation() + 1);
    }

    public int getBackwardLocation() {
        return getLocation() > 0 ? getLocation() - 1 : getMaxLocation();
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
