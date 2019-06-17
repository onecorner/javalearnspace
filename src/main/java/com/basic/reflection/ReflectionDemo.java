package com.basic.reflection;

import java.lang.reflect.Field;
import java.util.List;

import static java.lang.System.out;

/**
 *
 * @author jhons
 */
public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<?> c = FieldDemo.class;
        // Field field = c.getField("id");
        // Field field = c.getField("name");
        // Field field = c.getField("d");
        // Field field = c.getField("lo");
        Field field = c.getField("val");

        out.println("field 类型 " + field.getType());
        out.println("field 泛型:" + field.getGenericType());;
    }

}

class FieldDemo<T> {
    public int id = 1;
    public String name = "TianYa";
    public double[] d;
    public List<Object> lo;
    public T val;
}
