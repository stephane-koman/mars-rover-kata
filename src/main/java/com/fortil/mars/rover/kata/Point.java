package com.fortil.mars.rover.kata;

import com.fortil.mars.rover.kata.exceptions.LocationException;

public class Point {

    private final int location;
    private final int maxLocation;

    public Point(int location, int maxLocation) throws LocationException {
        if(location < 0)
            throw new LocationException("Location parameter cannot be less than ZERO");

        if(maxLocation < 0)
            throw new LocationException("maxLocation parameter cannot be less than ZERO");

        if(maxLocation < location )
            throw new LocationException("maxLocation parameter cannot be less than location parameter");

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
        return getLocation() + 1;
    }

    public int getBackwardLocation() {
        return getLocation() - 1;
    }
}
