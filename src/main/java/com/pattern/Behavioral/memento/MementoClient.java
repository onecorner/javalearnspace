package com.pattern.Behavioral.memento;

/**
 * @author jhons
 * @fomatter:off 场景：world的临时存储文档，悔棋，历史纪录
 * 目的：就是保存某个对象内部状态的拷贝，这样以后就可以将该对象恢复到源线的状态。
 * 结构：
 * 原发生器类Originator
 * 备忘录类：memento
 * 负责人类：CareTake
 * @formatter:on
 * @since 2019/6/1 16:42
 */
public class MementoClient {
    public static void main(String[] args) {
        CareTaker<EmpMemento> taker = new CareTaker();
        Emp emp = new Emp("lisi", 11, 1000D);
        EmpMemento empMemento = new EmpMemento(emp);
        taker.setT(empMemento);
        System.out.println(emp);
        System.out.println("-------------->");
        emp.setAge(16);
        emp.setName("wangwu");
        emp.setSalary(2000D);
        System.out.println(emp);
        System.out.println("-------------->");
        emp.recovery(taker.getT());
        System.out.println(emp);

    }
}
