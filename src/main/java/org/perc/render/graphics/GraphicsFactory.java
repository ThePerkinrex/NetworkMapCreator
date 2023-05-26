package org.perc.render.graphics;

import processing.core.PGraphics;

@FunctionalInterface
public interface GraphicsFactory {
	PGraphics createGraphics(int width, int height);
}
