package com.jdk8.lambda;

/**
 * @fomatter:off
 * lambda函数一句话总结，就是被覆盖的类只能有一个抽象方法,比如函数式接口，或者只有一个抽象方法的抽象类，
 * 这样才能推导出来 和匿名内部类的区别： 匿名内部类：会生成一个class文件 lambda:不会生成，且会延迟执行。
 * 好处：
 *    节省代码 延迟执行
 * @formatter:on
 * @author htj
 * @since 2019/6/2 11:30
 */
public class LambdaClient {
    public static void main(String[] args) {
        // 实现该接口 第一种
        System.out.println("a+b=" + new LambdaClient().oprator(100, 202, (a, b) -> a + b));

        // 可以用来提升性能
        // 如果不使用lambda的话就是下面的结果；
        String msg1 = "hello world";
        String msg2 = "new build ";
        String msg3 = "wan mei";
        // 这里面虽然没有打印出来，但是还是会拼接三个参数
        log(2, msg1 + msg2 + msg3);
        // 使用这种方式就不会进行拼接
        log(2, () -> msg1 + msg2 + msg3);
    }

    // 方式一：
    public static void log(int level, String message) {
        if (level == 1) {
            System.out.println(message);
        }
    }

    // 方式二：
    public static void log(int level, StringBuilder stringBuilder) {
        if (level == 1) {
            System.out.println(stringBuilder.build());
        }
    }

    /**
     * @fomatter:off
     * 延展概念
     * 函数式接口：只标名了一个抽象方法的接口,可以使用@FunctionalInterface来标记
     * maker接口：没有方法或属性的接口，空接口
     * @formatter:on
     * 下面这个接口就是一个函数式接口，只不过没有特别标记，当然使用@FunctionalInterface来标记的目的主要是用来解决编译上的错误
     * 
     * */
    interface MathOperation {
        int handle(int a, int b);
    }

    abstract class AbstractMethOperation implements MathOperation {
        abstract void excute(String message);

        @Override
        public int handle(int a, int b) {
            return a * b;
        }
    }

    private int oprator(int a, int b, MathOperation mathOperation) {
        return mathOperation.handle(a, b);
    }

    interface StringBuilder {
        String build();
    }

}
