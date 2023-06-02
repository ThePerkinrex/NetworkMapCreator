package org.perc.networkMap;

import org.perc.networkMap.config.Config;
import org.perc.networkMap.config.ConfigLoader;
import org.perc.networkMap.render.Renderer;
import org.xml.sax.SAXException;
import processing.core.PApplet;
import processing.data.XML;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DevMain {
	public static void main(String[] args) {
//		Renderer.saveWindowLocation = true;
//		String[] sketchArgs = null;
//		try {
//			Config c = new ConfigLoader().load(new XML(new File("config/config.xml")));
//			System.out.println(c);
//			sketchArgs = new String[1];
//			sketchArgs[0] = String.format("--location=%d,%d", c.windowX, c.windowY);
//		} catch (IOException | ParserConfigurationException | SAXException e) {
//			throw new RuntimeException(e);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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