package org.perc.networkMap.coords;

import org.perc.networkMap.xml.XMLLoader;
import processing.data.XML;

import java.text.ParseException;

public class CoordsLoader implements XMLLoader<Coords> {
	@Override
	public Coords load(XML x) throws ParseException {
		if (!x.hasAttribute("x") || !x.hasAttribute("y")) throw new ParseException("Coords object is malformed", 0);
		return new Coords(x.getInt("x"), x.getInt("y"));
	}
}
