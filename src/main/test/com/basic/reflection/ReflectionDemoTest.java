package com.basic.reflection;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author htj
 * @since 2019/6/13 15:11
 */
public class ReflectionDemoTest {

    @Test
    public void testGetGenericParameterTypes() throws NoSuchMethodException {
        class Fruit<T>
        {
            T mT;
            Fruit(T xt){
                mT=xt;
            }
            //无法通过反射获得返回的T的类型
            public List<T> get(){
                return null;
            }
        }

        Method get = Fruit.class.getMethod("get", null);
        System.out.println(get.getGenericExceptionTypes());

    }

}