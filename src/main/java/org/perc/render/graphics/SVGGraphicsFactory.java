package org.perc.render.graphics;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class SVGGraphicsFactory implements GraphicsFactory {
	private final PApplet parent;
	private final String output;

	public SVGGraphicsFactory(PApplet parent, String output) {
		this.parent = parent;
		this.output = output;
	}

	@Override
	public PGraphics createGraphics(int width, int height) {
		return parent.createGraphics(width, height, PConstants.SVG, output);
	}
}
