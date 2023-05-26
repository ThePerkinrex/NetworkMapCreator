package org.perc.render.graphics;

import processing.core.PApplet;
import processing.core.PGraphics;

public class Java2DGraphicsFactory implements GraphicsFactory{
	private final PApplet parent;

	public Java2DGraphicsFactory(PApplet parent) {
		this.parent = parent;
	}

	@Override
	public PGraphics createGraphics(int width, int height) {
		return parent.createGraphics(width, height);
	}
}
