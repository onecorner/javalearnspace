package com.pattern.Behavioral.mediator;

/**
 * @author htj
 * @since 2019/6/1 21:58
 */
public class Market implements Department {
    private Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("market", this);
    }

    @Override
    public void selfAction() {
        System.out.println("市场调研");
    }

    @Override
    public void outAction() {
        System.out.println("向上汇报调研进度");

    }
}
