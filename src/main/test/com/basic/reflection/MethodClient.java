package com.basic.reflection;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import static java.lang.System.out;

/**
 * @author htj
 * @since 2019/6/13 15:43
 */
public class MethodClient {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // 测试方法method
        testMethod();
    }

    private static void testMethod() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> c = PrintStream.class;
        Method[] allMethods = c.getDeclaredMethods();
        for (Method m : allMethods) {
            if (!m.getName().equals("printf")) {
                continue;
            }
            out.println("函数的泛型字符串表示:");
            out.println(m.toGenericString());// 也可使用toString()

            out.println("返回值类型（泛型）:");
            out.println(m.getReturnType());
            out.println(m.getGenericReturnType() + "(泛型)");

            Class<?>[] pType = m.getParameterTypes();
            // 获取参数的反省话形式
            Type[] gpType = m.getGenericParameterTypes();
            out.println("参数:");
            for (int i = 0; i < pType.length; i++) {
                out.println(pType[i]);
                out.println(gpType[i] + "(泛型)");
            }

            Class<?>[] eType = m.getExceptionTypes();
            Type[] geType = m.getGenericExceptionTypes();
            out.println("异常:");
            for (int i = 0; i < eType.length; i++) {
                out.println(eType[i]);
                out.println(geType[i] + "(泛型)");
            }
        }
    }
}
