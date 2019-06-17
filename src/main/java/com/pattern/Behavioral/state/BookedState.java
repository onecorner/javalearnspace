package com.pattern.Behavioral.state;

/**
 * @author jhons
 * @since 2019/6/1 14:24
 */
public class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("已预定");
    }
}
