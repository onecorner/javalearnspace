package com.pattern.bridge;

/**
 * @ClassName
 * @since: created in 2019-03-20 14:49
 * @author: htj
 * @modified by:
 * @version:
 **/
public class BridgePatternDemo {

	public static void main(String[] args) {
		// 要添加，否则slf4j无法打印日志
		Shape redShape = new Circle(1, 2, 3, new RedCircle());
		Shape greenShape = new Circle(1, 2, 3, new GreenCircle());
		redShape.draw();
		greenShape.draw();
	}
}
