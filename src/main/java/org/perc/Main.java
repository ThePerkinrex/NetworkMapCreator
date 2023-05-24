package org.perc;

import org.perc.coords.Coords;
import org.perc.map.line.Line;
import org.perc.map.node.Node;
import org.perc.map.node.SimpleNode;
import org.perc.map.node.StationNode;
import org.perc.map.station.SimpleStation;
import org.perc.map.station.Station;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Line blueLine = new Line("blue");
        Station stationA = new SimpleStation(Coords.ZERO, "A");
        Station stationB = new SimpleStation(new Coords(20,10), "B");
        blueLine.addLast(new StationNode(Coords.ZERO, stationA));
        blueLine.addLast(new SimpleNode(new Coords(10,0)));
        blueLine.addLast(new StationNode(Coords.ZERO, stationB));
        for(Node n : blueLine) {
            System.out.println("Node: " + n);
        }
        for (Iterator<Station> it = blueLine.stations().iterator(); it.hasNext(); ) {
            Station s = it.next();
            System.out.println("Station: " + s.getName());
        }

        for (Iterator<Line> it = stationA.lines().iterator(); it.hasNext(); ) {
            Line l = it.next();

            System.out.println("Line at station A: " + l);
        }
    }
}