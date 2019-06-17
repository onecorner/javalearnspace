package com.pattern.Behavioral.Observer;

/**
 * @fomatter:off
 * 广播机制的核心
 *     1对n的通知：当一个对象的状态变化时，它需要即使告知一系列对象，令他们做出反应。
 * 通知方式：
 *    推： 每次都会把通知以广播方式发给所有观察者，所有观察者只能被动接受
 *    拉：观察者只要知道有消息即可，至于什么时候获取具体内容，都可以自主决定。
 * 场景：聊天程序
 *
 * @formatter:on
 * @author jhons
 * @since 2019/6/1 14:22
 */
public class ObserverClient {
    public static void main(String[] args) {
        ConcrectSubject subject = new ConcrectSubject();
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();
        subject.register(obs1);
        subject.register(obs2);
        subject.register(obs3);
        subject.setState(5);
        System.out.println(obs1.getState());
        System.out.println(obs2.getState());
        System.out.println(obs3.getState());

    }
}
