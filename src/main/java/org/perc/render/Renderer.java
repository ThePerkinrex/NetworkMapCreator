package org.perc.render;

import org.perc.coords.Coords;
import org.perc.map.line.Line;
import org.perc.map.node.Node;
import org.perc.map.node.SimpleNode;
import org.perc.map.node.StationNode;
import org.perc.map.station.SimpleStation;
import org.perc.map.station.Station;
import org.perc.render.graphics.Java2DGraphicsFactory;
import org.perc.render.line.RenderedLine;
import org.perc.style.Style;
import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.Iterator;

public class Renderer extends PApplet {
    private int despX = 0;
    private int despY = 0;

    public int getDespX() {
        return despX;
    }

    public int getDespY() {
        return despY;
    }

    public Coords getDesp() {
        return new Coords(despX, despY);
    }

    public void settings(){
        size(600,600);
    }

    PGraphics pg;
    public void setup(){
        surface.setResizable(true);
        surface.setTitle("Netmap creator");
        RenderedLine rl = new RenderedLine(getExampleLine(), this);
        pg = rl.render(new Java2DGraphicsFactory(this));
    }
    public void draw(){
        background(128);
        RenderedLine rl = new RenderedLine(getExampleLine(), this);
        image(pg, 50,50);
//        background(0);
//        pg.beginDraw();
//        pg.background(102);
//        pg.stroke(255);
//        pg.line(pg.width*0.5f, pg.height*0.5f, mouseX, mouseY);
//        pg.endDraw();
//        image(pg, 50, 50);
    }

    private Line getExampleLine() {
        Line blueLine = new Line("blue", new Style(color(0,0,255)));
        Station stationA = new SimpleStation(Coords.ZERO, "Madrid");
        Station stationB = new SimpleStation(new Coords(20,10), "Zaragoza");
        Station stationC = new SimpleStation(new Coords(30,10), "Barcelona");
        blueLine.addLast(new StationNode(Coords.ZERO, stationA));
        blueLine.addLast(new SimpleNode(new Coords(10,0)));
        blueLine.addLast(new StationNode(Coords.ZERO, stationB));
        blueLine.addLast(new StationNode(Coords.ZERO, stationC));
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
        return blueLine;
    }
}
