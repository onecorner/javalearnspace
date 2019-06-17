package com.pattern.Behavioral.strategy;

/**
 * @fomatter:off
 * 优点：实现起来比较容易
 * 缺点：类型特别多，算法比较复杂时，条件语句的代码就会比较长，比较难以维护，不符合开闭原则
 * 这是普通的实现方法
 * @formatter:on
 * @author jhons
 * @since 2019/5/31 10:59
 */
public class StrategyCommonDemo {

    public static Double getPrice(String type, double price) {
        if ("普通客户小批量报价".equals(type)) {
            System.out.println("不打折，原价");
            return price;
        }

        return price;
    }
}
