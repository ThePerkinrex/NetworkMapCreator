package org.perc.networkMap.style;

public class Style {
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
}
