package org.perc.networkMap.style;

import org.perc.networkMap.xml.XMLLoader;
import org.perc.networkMap.xml.XMLSerializable;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.data.XML;

public class Style implements XMLSerializable {
	private int color;
	private LineStyle lineStyle;

	public Style(int color) {
		this(color, LineStyle.SOLID);
	}

	public Style(int color, LineStyle lineStyle) {
		this.color = color;
		this.lineStyle = lineStyle;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public LineStyle getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
	}

	private static String hexColor(int color) {
		StringBuilder res = new StringBuilder(8);
		res.append('#');
		for(int i = 28; i >= 0; i-=4) {
			int ch = (color >> i) & 0b1111;
			res.append(Integer.toString(ch,16));
		}
		return res.toString();
	}

	private static int hexColor(String color) {
		int res = 0;
		for (int i=0;i<color.length();i++) {
			char c = color.charAt(i);
			res = (res << 4) + Integer.parseInt(Character.toString(c), 16);
		}
		return res;
	}

	@Override
	public XML save(String name) {
		XML res = new XML(name);
		XML color = new XML("Color");
		color.setContent(hexColor(this.color));
		res.addChild(color);
		res.addChild(lineStyle.save());
		return res;
	}

	public static class Loader implements XMLLoader<Style> {
		@Override
		public Style load(XML xml) throws Exception {
			int color = hexColor(xml.getChild("Color").getContent().substring(1));
			LineStyle ls = new LineStyle.Loader().load(xml.getChild("LineStyle"));
			return new Style(color, ls);
		}
	}
}
