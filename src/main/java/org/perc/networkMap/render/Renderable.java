package org.perc.networkMap.render;

import org.perc.networkMap.render.graphics.GraphicsFactory;
import processing.core.PGraphics;

public interface Renderable {
	PGraphics render(GraphicsFactory factory);
}
