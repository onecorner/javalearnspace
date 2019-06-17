package com.pattern.structure.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 享元类
 * 
 * @author htj
 * @since 2019/6/2 0:56
 */
public interface ChessFlyweight {

    void setColor(String color);

    String getColor();

    void display(Coordinate coordinate);

}

@Data
@ToString
@AllArgsConstructor
@EqualsAndHashCode
class ConcreteChessFlyweight implements ChessFlyweight {
    private String color;

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("颜色是" + color);
        System.out.println("坐标是x" + coordinate.getX() + "-->y:" + coordinate.getY());
    }
}
