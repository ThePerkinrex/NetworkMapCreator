package org.perc.render;

import org.perc.render.graphics.GraphicsFactory;
import processing.core.PGraphics;

public interface Renderable {
	PGraphics render(GraphicsFactory factory);
}
