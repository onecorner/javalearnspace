package com.pattern.creation.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @formatter:off
 *
 * 静态内部类：
 *        实现了懒加载
 *        实现了线程安全
 *
 * 类加载本身就是线程安全的
 *
 * @formatter:on
 *
 * @author jhons
 * @since 2019/5/31 16:56
 */
public class SingletonStatic implements Serializable {

    private static SingletonStatic instance;

    private static boolean flag = false;

    private static class SingletonStaticInner {
        public static SingletonStatic instance = new SingletonStatic();
    }

    private SingletonStatic() {
        // 防止单例模式被反射
        synchronized (SingletonStatic.class) {
            if (flag == false) {
                flag = !flag;
            } else {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }

    public static SingletonStatic getInstance() {
        if (instance == null) {
            instance = SingletonStaticInner.instance;
        }
        return instance;
    }

    /**
     * 防止被序列化破坏
     */
    private Object readResolve() {
        return instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
        InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        // 单例模式
        /* SingletonStatic singletonStatic = getInstance();
        System.out.println(singletonStatic.toString());
        Class<SingletonStatic> classType = SingletonStatic.class;
        Constructor<SingletonStatic> c = classType.getDeclaredConstructor(null);
        c.setAccessible(true);
        singletonStatic = c.newInstance();
        System.out.println(singletonStatic.toString());*/
        // 序列化模式
        //  支持java.io.Serializable的对象都可以写入流中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(SingletonStatic.getInstance());
        //  根据字节流生成对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        SingletonStatic newSingleton = (SingletonStatic)ois.readObject();
        System.out.println(newSingleton == SingletonStatic.getInstance());

    }

}
