package org.perc.networkMap.coords;

import org.perc.networkMap.xml.XMLSerializable;
import processing.data.XML;

import java.text.ParseException;

public record Coords(int x, int y) implements XMLSerializable {
    public static final Coords ZERO = new Coords(0,0);
    public Coords add(Coords other) {
        return new Coords(x + other.x, y + other.y);
    }

    public Coords sub(Coords other) {
        return new Coords(x - other.x, y - other.y);
    }

    public XML save(String name) {
        XML x = new XML(name);
        x.setInt("x", this.x);
        x.setInt("y", this.y);
        return x;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
