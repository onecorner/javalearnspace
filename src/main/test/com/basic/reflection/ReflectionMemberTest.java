package com.basic.reflection;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @author htj
 * @since 2019/6/14 13:53
 */
@SuppressWarnings("all")
public class ReflectionMemberTest {

    class FatherClass {
        public String mFatherName;
        public int mFatherAge;

        public void printFatherMsg() {}
    }

    class SonClass extends FatherClass {

        private String mSonName;
        protected int mSonAge;
        public String mSonBirthday;

        public void printSonMsg() {
            System.out.println("Son Msg - name : " + mSonName + "; age : " + mSonAge);
        }

        private void setSonName(String name) {
            mSonName = name;
        }

        private void setSonAge(int age) {
            mSonAge = age;
        }

        private int getSonAge() {
            return mSonAge;
        }

        private String getSonName() {
            return mSonName;
        }
    }

    private Class mClass;

    @Before
    public void before() {
        mClass = SonClass.class;
        System.out.println("类的名称：" + mClass.getName());
    }

    /**
     * @fomatter:off
     * public java.lang.String mSonBirthday
     * public java.lang.String mFatherName
     * public int mFatherAge
     * @formatter:on
     * 输出 SonClass 类以及其所继承的父类( 包括 FatherClass 和 Object ) 的 public 方法
     * */
    @Test
    public void testGetField() {
        Field[] fields = mClass.getFields();
        System.out.println("getField---->");
        for (Field field : fields) {
            // 获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            // 输出变量的类型及变量名
            System.out.println(field.getType().getName() + " " + field.getName());
        }

    }

    /**
     * @fomatter:off
     * private java.lang.String mSonName
     * protected int mSonAge
     * public java.lang.String mSonBirthday
     * final com.basic.reflection.ReflectionMemberTest this$0
     * @formatter:on
     * 输出 SonClass 类的所有成员变量，不问访问权限。
     * */
    @Test
    public void testGetDeclaredFields() {
        Field[] fields = mClass.getDeclaredFields();
        System.out.println("getField---->");
        for (Field field : fields) {
            // 获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            // 输出变量的类型及变量名
            System.out.println(field.getType().getName() + " " + field.getName());
        }
    }

    /**
     * @fomatter:off
     * public void printSonMsg(  )
     * public void printFatherMsg(  )
     * public final void wait(  ) throws java.lang.InterruptedException
     * public final void wait( long arg0,int arg1, ) throws java.lang.InterruptedException
     * public final native void wait( long arg0, ) throws java.lang.InterruptedException
     * public boolean equals( java.lang.Object arg0, )
     * public java.lang.String toString(  )
     * public native int hashCode(  )
     * public final native java.lang.Class getClass(  )
     * public final native void notify(  )
     * public final native void notifyAll(  )
     * @formatter:on
     * 获取 SonClass 类所有 public 访问权限的方法，包括从父类继承的。
     * */
    @Test
    public void testGetMethods() {
        // 2.1 获取所有 public 访问权限的方法
        // 包括自己声明和从父类继承的
        Method[] mMethods = mClass.getMethods();

        // 3.遍历所有方法
        for (Method method : mMethods) {
            // 获取并输出方法的访问权限（Modifiers：修饰符）
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            // 获取并输出方法的返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " " + method.getName() + "( ");
            // 获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType().getName() + " " + parameter.getName() + ",");
            }
            // 获取并输出方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0) {
                System.out.println(" )");
            } else {
                for (Class c : exceptionTypes) {
                    System.out.println(" ) throws " + c.getName());
                }
            }
        }
    }

    /**
     * @fomatter:off
     * private int getSonAge(  )
     * private java.lang.String getSonName(  )
     * private void setSonName( java.lang.String arg0, )
     * public void printSonMsg(  )
     * private void setSonAge( int arg0, )
     * @formatter:on
     * 获取所有本类的的方法（不问访问权限）
     * */
    @Test
    public void testGetDeclaredMethods() {

        // 2.2 获取所有本类的的方法（不问访问权限）
        Method[] mMethods = mClass.getDeclaredMethods();

        // 3.遍历所有方法
        for (Method method : mMethods) {
            // 获取并输出方法的访问权限（Modifiers：修饰符）
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            // 获取并输出方法的返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " " + method.getName() + "( ");
            // 获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType().getName() + " " + parameter.getName() + ",");
            }
            // 获取并输出方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0) {
                System.out.println(" )");
            } else {
                for (Class c : exceptionTypes) {
                    System.out.println(" ) throws " + c.getName());
                }
            }
        }
    }

}
