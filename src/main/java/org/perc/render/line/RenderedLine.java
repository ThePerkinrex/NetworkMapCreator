package org.perc.render.line;

import org.perc.map.line.Line;
import org.perc.map.station.Station;
import org.perc.render.graphics.GraphicsFactory;
import org.perc.render.Renderable;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;

import java.util.Comparator;
import java.util.List;

public class RenderedLine implements Renderable {
    private int THICKNESS = 5;
    private int SPACING = 50;
    private int HEIGHT = 10;
    private final Line line;
    private final PApplet parent;

    public RenderedLine(Line line, PApplet parent) {

        this.line = line;
        this.parent = parent;
    }

    private float textWidth(PFont font, String text) {
        return textWidth(font, font.getSize(), text);
    }

    private float textWidth(PFont font, int size, String text) {
        float wide = 0;
        for (int i = 0; i < text.length(); i++) {
            // could add kerning here, but it just ain't implemented
            wide += font.width(text.charAt(i)) * size;
        }
        return wide;
    }

    @Override
    public PGraphics render(GraphicsFactory factory) {
        List<Station> stations = line.stations().toList();
        if (stations.size() == 0) throw new RuntimeException("No Stations in line");
        Station longestStationName = stations.stream().max(Comparator.comparingInt(a -> a.getName().length())).orElseThrow();
        PFont font = parent.createFont("fonts/roboto/Roboto-Regular.ttf", 20);
        int width = (stations.size()+1) * SPACING;
        float longestWidth = textWidth(font, longestStationName.getName());
        int height = HEIGHT + THICKNESS*3 + (int) longestWidth;

        PGraphics pg = factory.createGraphics(width, height);
        pg.beginDraw();
        pg.textFont(font);
        pg.stroke(line.getStyle().getColor());
        pg.strokeWeight(THICKNESS);
        float lineY = height- (float) THICKNESS /2;
        pg.line(SPACING, lineY,width-SPACING,lineY);
        for (int i = 0; i < stations.size(); i++) {
            float x = SPACING * (i+1);
            pg.line(x, lineY, x, lineY-HEIGHT);
            pg.push();
            pg.translate(x, height - HEIGHT - (float) THICKNESS*2);
            pg.rotate(-pg.PI*5/16);
            pg.fill(pg.color(0f));
            pg.text(stations.get(i).getName(), 0,0);
            pg.pop();
        }
        pg.dispose();
        pg.endDraw();
        return pg;
    }
}
