package com.pattern.Behavioral.strategy;

/**
 * @author jhons
 * @since 2019/5/31 11:08
 */
public class OldCustomerFewStrategy implements Strategy {
	@Override
	public Double getPrice(Double price) {
		System.out.println("打8.5");
		return price * 8.5;
	}
}
