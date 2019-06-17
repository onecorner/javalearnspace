package com.pattern.creation.singleton;

/**
 * @fomatter:off
 * 饿汉式：
 *    线程不安全
 *    实现了懒加载
 * @formatter:on
 * @author jhons
 * @since 2019/5/31 16:54
 */
public class SingletonLazy {
    private static SingletonLazy singletonHunger;

    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if (singletonHunger == null) {
            singletonHunger = new SingletonLazy();
        }
        return singletonHunger;
    }

}
