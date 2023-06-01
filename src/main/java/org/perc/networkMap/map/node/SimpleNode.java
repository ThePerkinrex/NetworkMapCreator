package org.perc.networkMap.map.node;

import org.perc.networkMap.coords.Coords;

public class SimpleNode extends Node {
    private Coords coords;

    public SimpleNode(Coords coords) {
        super();
        this.coords = coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    @Override
    public Coords getCoords() {
        return this.coords;
    }
}
