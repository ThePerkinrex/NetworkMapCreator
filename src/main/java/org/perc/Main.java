package org.perc;

import org.perc.render.Renderer;
import processing.core.PApplet;

public class Main {
    public static void main(String[] args) {
        PApplet.main(Renderer.class);
//        Line blueLine = new Line("blue");
//        Station stationA = new SimpleStation(Coords.ZERO, "A");
//        Station stationB = new SimpleStation(new Coords(20,10), "B");
//        blueLine.addLast(new StationNode(Coords.ZERO, stationA));
//        blueLine.addLast(new SimpleNode(new Coords(10,0)));
//        blueLine.addLast(new StationNode(Coords.ZERO, stationB));
//        for(Node n : blueLine) {
//            System.out.println("Node: " + n);
//        }
//        for (Iterator<Station> it = blueLine.stations().iterator(); it.hasNext(); ) {
//            Station s = it.next();
//            System.out.println("Station: " + s.getName());
//        }
//
//        for (Iterator<Line> it = stationA.lines().iterator(); it.hasNext(); ) {
//            Line l = it.next();
//
//            System.out.println("Line at station A: " + l);
//        }
    }
}