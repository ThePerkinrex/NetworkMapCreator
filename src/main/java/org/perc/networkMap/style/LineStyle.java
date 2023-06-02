package org.perc.networkMap.style;

import org.perc.networkMap.xml.XMLLoader;
import org.perc.networkMap.xml.XMLSerializable;
import processing.data.XML;

public enum LineStyle implements XMLSerializable {


	SOLID,
	DOUBLE;

	public static class Loader implements XMLLoader<LineStyle> {

		@Override
		public LineStyle load(XML xml) throws Exception {
			switch (xml.getContent().toUpperCase()) {
				case "SOLID" -> {
					return LineStyle.SOLID;
				}
				case "DOUBLE" -> {
					return LineStyle.DOUBLE;
				}
				default -> throw new Exception("Unknown Line style: " + xml.getContent());
			}
		}
	}

	@Override
	public XML save(String name) {
		XML res = new XML(name);
		switch (this) {
			case SOLID -> res.setContent("SOLID");
			case DOUBLE -> res.setContent("DOUBLE");
		}
		return res;
	}
}
