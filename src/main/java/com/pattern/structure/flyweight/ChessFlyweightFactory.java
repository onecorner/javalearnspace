package com.pattern.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 * 
 * @author htj
 * @since 2019/6/2 1:06
 */
public class ChessFlyweightFactory {
    private static Map<String, ChessFlyweight> map = new HashMap<>();

    public static ChessFlyweight gerChessweight(String color) {
        if (map.get(color) == null) {
            ConcreteChessFlyweight concreteChessFlyweight = new ConcreteChessFlyweight(color);
            map.put(color, concreteChessFlyweight);
            return concreteChessFlyweight;
        } else
            return map.get(color);
    }
}
