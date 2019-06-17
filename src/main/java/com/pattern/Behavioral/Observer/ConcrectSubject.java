package com.pattern.Behavioral.Observer;

/**
 * @author jhons
 * @since 2019/6/1 16:02
 */
public class ConcrectSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObservers();
    }

}
