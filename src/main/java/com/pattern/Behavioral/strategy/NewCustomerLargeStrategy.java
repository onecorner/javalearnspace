package com.pattern.Behavioral.strategy;

/**
 * @author jhons
 * @since 2019/5/31 11:08
 */
public class NewCustomerLargeStrategy implements Strategy {
    @Override
    public Double getPrice(Double price) {
        System.out.println("打9折，0.9");
        return price*0.9;
    }
}
