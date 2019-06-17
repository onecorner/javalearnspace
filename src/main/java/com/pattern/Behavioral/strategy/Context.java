package com.pattern.Behavioral.strategy;

/**
 * 负责和具体的策略交互 这样的画，具体的算法和直接的客户端调用分离了，使得算法可以独立于客户端独立的变化
 *
 * 如果使用spring容器的话，可以动态的切换不同的策略对象。
 * 
 * @author jhons
 * @since 2019/5/31 11:11
 */
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Double getPrice(Double price) {
		return this.strategy.getPrice(price);
	}
}
