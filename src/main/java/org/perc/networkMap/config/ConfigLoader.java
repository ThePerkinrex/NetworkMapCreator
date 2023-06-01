package org.perc.networkMap.config;

import org.perc.networkMap.coords.Coords;
import org.perc.networkMap.coords.CoordsLoader;
import org.perc.networkMap.xml.XMLLoader;
import processing.data.XML;

import java.text.ParseException;

public class ConfigLoader implements XMLLoader<Config> {
	@Override
	public Config load(XML x) throws Exception {
		XML pos = x.getChild("WindowPosition");
		if (pos == null) throw new Exception("window position not present");
		Coords c = new CoordsLoader().load(pos);
		return new Config(c.x(), c.y());
	}
}
