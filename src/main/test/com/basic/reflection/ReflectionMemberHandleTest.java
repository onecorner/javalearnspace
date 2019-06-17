package com.basic.reflection;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author htj
 * @since 2019/6/14 14:22
 */
public class ReflectionMemberHandleTest {

    private InnerClass testClass;
    private Class<InnerClass> innerClazz;
    private Class<ReflectionMemberHandleTest> outterClazz;

    /**
     * 内部类的反射实例
     */
    @Before
    public void before()
        throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        outterClazz = ReflectionMemberHandleTest.class;
        innerClazz = InnerClass.class;
        Constructor<InnerClass> declaredConstructor = innerClazz.getDeclaredConstructor(outterClazz);
        testClass = declaredConstructor.newInstance(outterClazz.newInstance());
    }

    /**
     * 测试私有方法
     */
    @Test
    public void testGetPrivateMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // 2. 获取私有方法
        // 第一个参数为要获取的私有方法的名称
        // 第二个为要获取方法的参数的类型，参数为 Class...，没有参数就是null
        // 方法参数也可这么写 ：new Class[]{String.class , int.class}
        Method privateMethod = innerClazz.getDeclaredMethod("privateMethod", String.class, int.class);
        // 3. 开始操作方法
        if (privateMethod != null) {
            // 获取私有方法的访问权
            // 只是获取访问权，并不是修改实际权限
            privateMethod.setAccessible(true);

            // 使用 invoke 反射调用私有方法
            // privateMethod 是获取到的私有方法
            // testClass 要操作的对象
            // 后面两个参数传实参
            privateMethod.invoke(testClass, "Java Reflect ", 666);
        }
    }

    /**
     * 修改私有变量
     * */
    @Test
    public void testModifyFieldPriv() throws NoSuchFieldException, IllegalAccessException {
        // 2. 获取私有变量
        Field privateField = innerClazz.getDeclaredField("MSG");

        // 3. 操作私有变量
        if (privateField != null) {
            // 获取私有变量的访问权
            privateField.setAccessible(true);

            // 修改私有变量，并输出以测试
            System.out.println("Before Modify：MSG = " + testClass.getMsg());

            // 调用 set(object , value) 修改变量的值
            // privateField 是获取到的私有变量
            // testClass 要操作的对象
            // "Modified" 为要修改成的值
            privateField.set(testClass, "Modified");
            System.out.println("After Modify：MSG = " + testClass.getMsg());
        }

    }

    class InnerClass {

        private String MSG = "Original";

        private void privateMethod(String head, int tail) {
            System.out.print(head + tail);
        }

        public String getMsg() {
            return MSG;
        }
    }

}
