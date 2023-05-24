package org.perc.map.station;

import org.perc.coords.Coords;
import org.perc.map.line.Line;
import org.perc.map.node.Node;
import org.perc.map.node.StationNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class Station {
    protected Coords coords;
    protected String name;
    protected List<StationNode> nodes;

    public Station(Coords coords, String name) {
        this.coords = coords;
        this.name = name;
        this.nodes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNode(StationNode n) {
        this.nodes.add(n);
    }

    public void removeNode(StationNode n) {
        this.nodes.remove(n);
    }

    public Stream<Line> lines() {
        return nodes.stream().map(Node::getLine);
    }

    public Coords getCoords() {
        return coords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (!Objects.equals(coords, station.coords)) return false;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        int result = coords != null ? coords.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Station{" +
                "coords=" + coords +
                ", name='" + name + '\'' +
                '}';
    }
}
