package com.pattern.structure.flyweight;

/**
 * @fomatter:off
 * 享原模式：
 *        节约内存，如果有多个完全相同的对象，我们可以通过享元模式来节省内存
 * 对象能够做到共享的原因是因为区分了内部状态和外部状态。
 * @formatter:on
 * @author htj
 * @since 2019/6/2 0:50
 */
public class FlyweightClient {
    public static void main(String[] args) {
        ChessFlyweight chessFlyweight = ChessFlyweightFactory.gerChessweight("黑色");
        chessFlyweight.display(new Coordinate(1, 4));
    }
}
