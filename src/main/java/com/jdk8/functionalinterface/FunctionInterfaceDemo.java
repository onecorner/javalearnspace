package com.jdk8.functionalinterface;

/**
 * @fomatter:off
 * 函数式接口：只标名了一个抽象方法的接口,可以使用@FunctionalInterface来标记
 * jdk8：接口可以有默认方法实现，使用default来修饰。
 * @formatter:on
 * @FunctionalInterface demo
 * @author htj
 * @since 2019/6/2 15:04
 */
public class FunctionInterfaceDemo {
    public static void invoker(String name, MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.invoke(name);
    }

    public static void main(String[] args) {
        // 方式一
        invoker("test", System.out::println);
        // 方式二
        MyFunctionalInterface functionalInterface = (name) -> {
            System.out.println(name);
        };
        invoker("test111111", functionalInterface);
        // 方式三
        functionalInterface.invoke("this3333333");
    }

}

@FunctionalInterface
interface MyFunctionalInterface {
    void invoke(String name);
}
