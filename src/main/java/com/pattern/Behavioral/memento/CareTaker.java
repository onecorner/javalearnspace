package com.pattern.Behavioral.memento;

import lombok.Data;

/**
 * 负责人类 负责管理备忘录对象
 * 
 * @author jhons
 * @since 2019/6/1 17:43
 */
@Data
public class CareTaker<T> {
    private T t;
}
