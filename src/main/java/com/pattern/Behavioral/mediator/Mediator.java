package com.pattern.Behavioral.mediator;

/**
 * @author htj
 * @since 2019/6/1 21:56
 */
public interface Mediator {

    void command(String name);

    void register(String name, Department department);
}
