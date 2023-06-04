package org.perc.networkMap.render;

import org.perc.networkMap.config.Config;
import org.perc.networkMap.coords.Coords;
import org.perc.networkMap.map.Map;
import org.perc.networkMap.map.line.Line;
import org.perc.networkMap.map.node.SimpleNode;
import org.perc.networkMap.map.node.StationNode;
import org.perc.networkMap.map.station.SimpleStation;
import org.perc.networkMap.map.station.Station;
import org.perc.networkMap.render.graphics.Java2DGraphicsFactory;
import org.perc.networkMap.render.line.RenderedLine;
import org.perc.networkMap.style.Style;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.data.XML;

import java.io.File;

public class Renderer extends PApplet {
    public static boolean saveWindowLocation = false;

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
        image(pg, 50,50);
//        background(0);
//        pg.beginDraw();
//        pg.background(102);
//        pg.stroke(255);
//        pg.line(pg.width*0.5f, pg.height*0.5f, mouseX, mouseY);
//        pg.endDraw();
//        image(pg, 50, 50);
    }

    @Override
    public void exitActual() {
        if(saveWindowLocation) {
            XML conf = new Config(windowX, windowY).save();
            conf.save(new File("config/config.xml"));
        }
        super.exitActual();
    }

    private Line getExampleLine() {
        Line blueLine = new Line("blue", new Style(color(0,0,255)));
        Station stationA = new SimpleStation(Coords.ZERO, "Madrid");
        Station stationB = new SimpleStation(new Coords(20,10), "Zaragoza");
        Station stationC = new SimpleStation(new Coords(30,10), "Barcelona");
        blueLine.addLast(new StationNode(Coords.ZERO, stationA));
        blueLine.addLast(new SimpleNode(new Coords(10, 0)));
        blueLine.addLast(new StationNode(Coords.ZERO, stationB));
        blueLine.addLast(new StationNode(Coords.ZERO, stationC));
        Map m = new Map();
        m.getLines().add(blueLine);
        XML map = m.save();

        System.out.println(map.format(4));
        try {
            Map m2 = new Map.Loader().load(map);
            System.out.println(m2.save("yes").format(4));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
