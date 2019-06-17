package com.pattern.Behavioral.template;

/**
 * @author jhons
 * @since 2019/5/31 11:33
 */
public abstract class BankTemplateMethod {
	// 取号
	protected void takeNumber() {
		System.out.println("取号排队");
	}

	/**
	 * 办理业务
	 */
    protected abstract void transact();

	/**
	 * 
	 * 评价反馈
	 */
    protected void evaluate() {
		System.out.println("反馈评价");
	}

	public final void process() {
		this.takeNumber();
		this.transact();
		this.evaluate();
	}

}
