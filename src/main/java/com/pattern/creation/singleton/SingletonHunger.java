package com.pattern.creation.singleton;

/**
 * @fomatter:off
 * 饿汉式：
 * 不支持懒加载
 * 线程安全
 *
 *
 * @fomatter:on
 * @author jhons
 * @since 2019/5/31 16:52
 */
public class SingletonHunger {

    private static SingletonHunger singletonHunger = new SingletonHunger();

    private SingletonHunger() {}

    public static SingletonHunger getInstance() {
        return singletonHunger;
    }

}
