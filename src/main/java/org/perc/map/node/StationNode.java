package org.perc.map.node;

import org.perc.coords.Coords;
import org.perc.map.line.Line;
import org.perc.map.station.Station;

public class StationNode extends Node {
    private final Coords relativeCoords;
    private final Station station;

    public StationNode(Coords relativeCoords, Station station) {
        super();
        this.relativeCoords = relativeCoords;
        this.station = station;
        this.station.addNode(this);
    }

    public Station getStation() {
        return station;
    }

    @Override
    public Coords getCoords() {
        return relativeCoords.add(station.getCoords());
    }
}
