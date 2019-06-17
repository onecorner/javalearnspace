package com.pattern.Behavioral.mediator;

/**
 * @author htj
 * @since 2019/6/1 21:58
 */
public class Development implements Department {
    private Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("development",this);
    }

    @Override public void selfAction() {
        System.out.println("专心科研");
    }

    @Override public void outAction() {
        System.out.println("向上汇报工作");

    }
}
