package com.pattern.Behavioral.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author htj
 * @since 2019/6/1 22:04
 */
public class President implements Mediator {
    private Map<String, Department> map = new HashMap<>();

    @Override
    public void command(String name) {
        this.map.get(name).selfAction();
    }

    @Override
    public void register(String name, Department department) {
        this.map.put(name, department);
    }
}
