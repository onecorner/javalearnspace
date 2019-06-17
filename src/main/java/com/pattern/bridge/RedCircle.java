package com.pattern.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName
 * @since: created in 2019-03-20 14:34
 * @author: htj
 * @modified by:
 * @version:
 **/
@Slf4j
public class RedCircle implements DrawApi {
	@Override
	public void drawCiycle(int radius, int x, int y) {
		// log.info("Drawing Circle[ color: red, radius: {}, x: {}, y:{}]", radius, x,
		// y);
	}
}
