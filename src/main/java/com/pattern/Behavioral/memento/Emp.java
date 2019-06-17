package com.pattern.Behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 源发器类
 * 
 * @author jhons
 * @since 2019/6/1 17:26
 */

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Emp {

    private String name;
    private int age;
    private double salary;

    // 进行备忘录操作，并返回备忘录对象
    public EmpMemento getMemento() {
        return new EmpMemento(this);
    }

    // 进行数据恢复
    public void recovery(EmpMemento empMemento) {
        this.name = empMemento.getName();
        this.age = empMemento.getAge();
        this.salary = empMemento.getSalary();
    }
}
