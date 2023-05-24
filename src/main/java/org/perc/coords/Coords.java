package org.perc.coords;

public record Coords(int x, int y) {
    public static final Coords ZERO = new Coords(0,0);
    public Coords add(Coords other) {
        return new Coords(x + other.x, y + other.y);
    }

    public Coords sub(Coords other) {
        return new Coords(x - other.x, y - other.y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
