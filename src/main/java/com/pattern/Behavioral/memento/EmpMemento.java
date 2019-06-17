package com.pattern.Behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 备忘录类
 * 
 * @author jhons
 * @since 2019/6/1 17:27
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class EmpMemento {

    private String name;
    private int age;
    private double salary;

    public EmpMemento(Emp emp) {
        this.age = emp.getAge();
        this.name = emp.getName();
        this.salary = emp.getSalary();
    }

}
