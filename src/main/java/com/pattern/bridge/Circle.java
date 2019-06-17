package com.pattern.bridge;

/**
 * @ClassName
 * @since: created in 2019-03-20 14:45
 * @author: htj
 * @modified by:
 * @version:
 **/
public class Circle extends Shape {

	private int radiux;
	private int y;
	private int x;

	public Circle(int radiux, int x, int y, DrawApi drawApi) {
		super(drawApi);
		this.x = x;
		this.y = y;
		this.radiux = radiux;
	}

	@Override
	protected void draw() {
		drawApi.drawCiycle(radiux, x, y);
	}
}
