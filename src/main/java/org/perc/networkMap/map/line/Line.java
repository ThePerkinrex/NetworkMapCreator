package org.perc.networkMap.map.line;

import org.perc.networkMap.map.node.Node;
import org.perc.networkMap.map.node.StationNode;
import org.perc.networkMap.map.station.Station;
import org.perc.networkMap.style.Style;

import java.util.*;
import java.util.stream.Stream;

public class Line implements Iterable<Node> {
    private List<Node> nodes;
    private String name;
    private final Style style;
    public Line(String name, Style style) {
        this.name = name;
        this.nodes = new ArrayList<>();
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    public void addBefore(int node, Node n) {
        n.setLine(this);
        nodes.add(node, n);
    }

    public void addLast(Node n) {
        n.setLine(this);
        nodes.add(n);
    }

    public void remove(Node n) {
        n.setLine(null);
        nodes.remove(n);
    }

    public void remove(int n) {
        nodes.remove(n).setLine(null);
    }

    public Node getNode(int n) throws IndexOutOfBoundsException {
        return nodes.get(n);
    }

    public int size() {
        return nodes.size();
    }

    public Stream<Station> stations() {
        return nodes.stream().map(x -> x instanceof StationNode stationNode ? stationNode.getStation() : null).filter(Objects::nonNull);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " line";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!Objects.equals(nodes, line.nodes)) return false;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        int result = nodes != null ? nodes.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public Iterator<Node> iterator() {
        return nodes.iterator();
    }
}
