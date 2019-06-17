package com.pattern.Behavioral.state;

/**
 * @fomatter:off
 * 核心：用于解决复杂对象的状态转换以及不同状态下行为的封装问题
 * 结构：
 *     context环境类：维护一个state对象，定义了当前的状态
 *     state抽象类：
 *     具体的状态实现类：封装相对应的行为
 * @formatter:on
 *
 * @author jhons
 * @since 2019/6/1 14:20
 */
public class StateClient {

    public static void main(String[] args) {
        Context tx = new Context();
        tx.setState(new FreeState());
        tx.setState(new BookedState());
    }
}
