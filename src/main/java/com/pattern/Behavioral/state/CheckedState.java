package com.pattern.Behavioral.state;

/**
 * @author jhons
 * @since 2019/6/1 14:25
 */
public class CheckedState implements State {
    @Override
    public void handle() {
        System.out.println("已入住");
    }
}
