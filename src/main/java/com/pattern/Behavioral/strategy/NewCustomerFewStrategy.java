package com.pattern.Behavioral.strategy;

/**
 * @author jhons
 * @since 2019/5/31 11:07
 */
public class NewCustomerFewStrategy implements Strategy {
	@Override
	public Double getPrice(Double price) {
		System.out.println("不打折，原价");
		return price;
	}
}
