package org.perc.map.node;

import org.perc.coords.Coords;
import org.perc.map.line.Line;

import java.util.Objects;

public abstract class Node {
    protected Line line;

    public Node() {
        this.line = null;
    }

    public Line getLine() {
        return this.line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public abstract Coords getCoords();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!Objects.equals(line, node.line)) return false;
        return Objects.equals(getCoords(), node.getCoords());
    }

    @Override
    public int hashCode() {
        int result = line != null ? line.hashCode() : 0;
        result = 31 * result + (getCoords() != null ? getCoords().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "line=" + line +
                ", coords=" + getCoords() +
                '}';
    }
}
