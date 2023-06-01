package org.perc.networkMap.config;

import org.perc.networkMap.coords.Coords;
import org.perc.networkMap.xml.XMLSerializable;
import processing.data.XML;

import java.text.ParseException;

public class Config implements XMLSerializable {
	public int windowX;
	public int windowY;

	public Config(int windowX, int windowY) {
		this.windowX = windowX;
		this.windowY = windowY;
	}

	@Override
	public XML save(String name) {
		XML res = new XML(name);
		XML windowPos = new Coords(windowX, windowY).save("WindowPosition");
		res.addChild(windowPos);
		return res;
	}

	@Override
	public String toString() {
		return "Config{" + "windowX=" + windowX + ", windowY=" + windowY + '}';
	}
}
