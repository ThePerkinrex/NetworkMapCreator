package org.perc.map.station;

import org.perc.coords.Coords;
import org.perc.map.node.StationNode;

public class SimpleStation extends Station {
    public SimpleStation(Coords coords, String name) {
        super(coords, name);
    }

    @Override
    public void addNode(StationNode n) {
        if (nodes.size() > 0) System.err.println("[WARN] Adding more than one node to a simple station");
        super.addNode(n);
    }
}
