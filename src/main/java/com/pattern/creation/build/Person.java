package com.pattern.creation.build;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author jhons
 * @since 2019/5/31 16:09
 */
@Data
@ToString
@EqualsAndHashCode
public class Person {
    private String head;
    private String body;
    private String foot;
}

class Man extends Person {
    public Man() {
        System.out.println("开始建造男人");
    }
}

class Woman extends Person {
    public Woman() {
        System.out.println("开始建造女人");
    }
}
