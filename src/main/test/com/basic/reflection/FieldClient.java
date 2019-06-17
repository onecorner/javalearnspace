package com.basic.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @author htj
 * @since 2019/6/13 15:24
 */
public class FieldClient {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        // 获取值类型
        // getFieldType();
        // 获取/设置字段值
        // getOrSetField();

        // 测试字段的权限
        // testFieldExceptionTest();
    }



    private static void testFieldExceptionTest() throws NoSuchFieldException, IllegalAccessException {
        class FieldExceptionTest {
            private boolean b = true;

            public boolean isB() {
                return b;
            }
        }

        FieldExceptionTest ft = new FieldExceptionTest();
        Class<?> c = ft.getClass();
        Field f = c.getDeclaredField("b");
        // f.setAccessible(true); //取消访问权限
        f.setBoolean(ft, Boolean.FALSE); // IllegalAccessException
        System.out.println(ft.isB());

    }

    private static void getOrSetField() throws NoSuchFieldException, IllegalAccessException {
        class People {
            private int id = 1;
            private String name = "zhang san";
            private Sex sex = Sex.MALE;
            private String[] friends = {"李四", "王五"};
        }

        People p = new People();
        Class<?> c = p.getClass();
        // -------------------------------
        Field Id = c.getDeclaredField("id");
        System.out.println("id原来的值:" + p.id);
        Id.setInt(p, 2);
        System.out.println("id改动后的值:" + p.id);
        // ---------------------------------
        Field gender = c.getDeclaredField("sex");
        System.out.println("sex原来的值:" + p.sex);
        gender.set(p, Sex.FEMALE);
        System.out.println("sex改动后的值:" + p.sex);
        // ----------------------------------
        Field fri = c.getDeclaredField("friends");
        System.out.println("friends原来的值:" + Arrays.asList(p.friends));
        String[] newFriends = {"赵六", "小七"};
        fri.set(p, newFriends);
        System.out.println("friends改动后的值:" + Arrays.asList(p.friends));
    }

    // 获取值类型
    private static void getFieldType() throws NoSuchFieldException {
        class FieldDemo<T> {
            public int id = 1;
            public String name = "TianYa";
            public double[] d;
            public List<Object> lo;
            public T val;
        }

        Class<?> c = com.basic.reflection.FieldDemo.class;
        Field field = c.getField("val");
        // class java.lang.Object
        out.println("field 类型 " + field.getType());
        // T
        out.println("field 泛型:" + field.getGenericType());
        field = c.getField("id");
        out.println("field 类型 " + field.getType());
        out.println("field 泛型:" + field.getGenericType());
        field = c.getField("name");
        out.println("field 类型 " + field.getType());
        out.println("field 泛型:" + field.getGenericType());
        field = c.getField("d");
        // class [D
        out.println("field 类型 " + field.getType());
        // class [D
        out.println("field 泛型:" + field.getGenericType());
    }

}

enum Sex {
    MALE, FEMALE
}
