package com.pattern.bridge;

/**
 * @ClassName
 * @since: created in 2019-03-20 14:43
 * @author: htj
 * @modified by:
 * @version:
 **/
public abstract class Shape {
	protected DrawApi drawApi;

	protected Shape(DrawApi drawApi) {
		this.drawApi = drawApi;
	}

	protected abstract void draw();
}
