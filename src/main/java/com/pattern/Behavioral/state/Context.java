package com.pattern.Behavioral.state;

/**
 * @author jhons
 * @since 2019/6/1 14:22
 */
public class Context {

    private State state;

    public void setState(State state) {
        System.out.println("修改状态");
        this.state = state;
        state.handle();
    }
}
