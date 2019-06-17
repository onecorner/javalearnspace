package com.basic.reflection;

/**
 * @author htj
 * @since 2019/6/13 16:57
 */
public class IsInstance {
    public static void main(String[] args) {
        Human human = new Human();
        Class[] classes = new Class[]{int.class,String.class};
        //判断obj是否是Instance类的实例
        System.out.println(Human.class.isInstance(human));
        // classes对象是否是class[].class类型的实例
        System.out.println(Class[].class.isInstance(classes));
        System.out.println(((Object)null).getClass());

        // 测试isArray的用法
        Object[] objArray = new Object[10];
        human.isArray(objArray.getClass());
        // 判断isAssignableForm的用法 用法A.isAssignableFrom(b) b是否是A的子类
        System.out.println(Object.class.isAssignableFrom(human.getClass()));
        System.out.println("----->"+Object.class.isAssignableFrom(Object.class));
        //getComponentType的用法
        int[] arrs = new int[]{1,2,3};
        String[] two = new String[4];
        printComponentType(two);

    }

    /**
     * 返回数组类型，比如int[]，返回的就是int
     * */
    static void printComponentType(Object array) {
        Class arrayClass = array.getClass();
        String arrayName = arrayClass.getName();
        Class componentClass = arrayClass.getComponentType();
        System.out.println(componentClass);
        String componentName = componentClass.getName();
        System.out.println("ArrayClass:"+arrayClass+" ,----ArrayName: " + arrayName + ",------- Component: "
            + componentName);
    }
}

class Human {
    public void isArray(Class clazz){
        // 判断指定对象是否数组对象
        System.out.println(clazz.isArray());
    }
}
