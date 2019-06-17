package com.pattern.Behavioral.mediator;

/**
 * @author htj
 * @since 2019/6/1 22:01
 */
public class Finacial implements Department {

    private Mediator mediator;

    public Finacial(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("finacial", this);
    }

    @Override
    public void selfAction() {
        System.out.println("finacial ，我在数千");
    }

    @Override
    public void outAction() {
        System.out.println("数千");
    }
}
