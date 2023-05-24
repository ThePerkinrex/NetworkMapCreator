package org.perc.map.node;

import org.perc.coords.Coords;
import org.perc.map.line.Line;

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
