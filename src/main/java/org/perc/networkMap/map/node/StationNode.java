package org.perc.networkMap.map.node;

import org.perc.networkMap.coords.Coords;
import org.perc.networkMap.map.station.Station;

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
