package org.perc.render.line;

import org.perc.map.line.Line;
import org.perc.map.station.Station;
import processing.awt.PGraphicsJava2D;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;

import java.util.Comparator;
import java.util.List;

public class RenderedLine extends PGraphicsJava2D {
    private int THICKNESS = 5;
    private int SPACING = 50;
    private int HEIGHT = 10;
    private final Line line;

    public RenderedLine(Line line, PApplet parent) {
        super();
        this.line = line;
        this.setParent(parent);
        this.setPrimary(false);
        this.setSize(0, 0);
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

    public void render(int color) {
        List<Station> stations = line.stations().toList();
        if (stations.size() == 0) throw new RuntimeException("No Stations in line");
        Station longestStationName = stations.stream().max(Comparator.comparingInt(a -> a.getName().length())).orElseThrow();
        System.out.println("Longest station name: " + longestStationName);
        PFont font = parent.createFont("fonts/roboto/Roboto-Regular.ttf", 100);


        int width = (stations.size()+1) * SPACING;
        float longestWidth = textWidth(font, longestStationName.getName());
        int height = HEIGHT + THICKNESS*2 + (int) longestWidth;
        setSize(width,height);
        beginDraw();
        stroke(color);
        strokeWeight(THICKNESS);
        float lineY = height- (float) THICKNESS /2;
        line(SPACING, lineY,width-SPACING,lineY);
        for (int i = 0; i < stations.size(); i++) {
            float x = SPACING * (i+1);
            line(x, lineY, x, lineY-HEIGHT);
        }
        endDraw();
    }
}
