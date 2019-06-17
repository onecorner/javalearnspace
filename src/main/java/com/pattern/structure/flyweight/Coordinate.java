package com.pattern.structure.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 外部状态
 * 非共享的享元类
 * @author htj
 * @since 2019/6/2 0:57
 */
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Coordinate {
    private int x, y;

}
