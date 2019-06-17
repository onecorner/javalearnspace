package com.pattern.Behavioral.Observer;

/**
 * @author jhons
 * @since 2019/6/1 15:56
 */
public interface Observer {
    void subscrible(Subject subject);
}

class ObserverA implements Observer {
    private int state;



    @Override
    public void subscrible(Subject subject) {
        state = ((ConcrectSubject)subject).getState();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
