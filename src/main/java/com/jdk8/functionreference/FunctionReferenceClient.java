package com.jdk8.functionreference;

import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用
 * @author htj
 * @since 2019/6/3 9:28
 */
public class FunctionReferenceClient {
    public static void main(String[] args) {
        // 构造器引用：Class::new
        Car car = Car.create(Car::new);
        car.setAge(11);
        System.out.println(car);
        List<Car> cars = new LinkedList<>(Arrays.asList(car));
        cars.add(new Car());
        cars.add(Car.create(Car::new));
        cars.add(Car.create(Car::new));
        // 静态方法引用：它的语法是Class::static_method
        //cars.forEach(Car::collide);
        // 特定类的任意对象的方法引用：
        cars.forEach(Car::repair);

        // 特定对象的方法引用：它的语法是instance::method实例如下：

        final Car police = Car.create(Car::new);
        police.setAge(20);
        cars.forEach(police::follow);
    }
}

@Data
@ToString
class Car {

    private int age;

    /**
     * Supplier是jdk1.8的接口，这里和lamda一起使用了
     */
    static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    void repair() {
        System.out.println("Repaired " + this.toString());
    }
}