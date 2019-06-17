package com.pattern.Behavioral.strategy;

/**
 * 策略者模式：
 * 场景：
 *  某个市场人员街道但后的报价策略（CRM系统中常见问题）。报价策略很复杂，可以简单作为如下分类：
 *      普通客户小批量报价
 *      普通客户大批量报价
 *      老客户小批量报价
 *      老客户大批量报价
 *  具体选用那个报价策略，这需要根据实际情况来确定。这时候，我们采用策略模式即可。
 *
 *  优点：允许用户从该算法族中任选一个算法解决问题，同时可以方便的更换算法或者增加新的算法
 * @author jhons
 * @since 2019/5/31 10:53
 */
public class StrategyClient {
    public static void main(String[] args) {
        Context context = new Context(new NewCustomerFewStrategy());
        System.out.println(context.getPrice(100d));

    }


}
