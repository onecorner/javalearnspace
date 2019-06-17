package com.jdk8.commonuse;

import java.util.function.Supplier;

/**
 * @author htj
 * @since 2019/6/2 15:52
 */
public class SupplierClient {
    // 直接返回一个字符串
    public static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        System.out.println(getString(() -> "test"));
        // 求最大值
        int[] arrs = new int[] {3, 545, 2323, 44, 12, 2323, 323, 23, 23};
        System.out.println(getMax(() -> {
            int max = arrs[0];
            for (int i = 1; i < arrs.length; i++) {
                if (arrs[i] > max)
                    max = arrs[i];
            }
            return max;
        }));

        System.out.println("方法二");
        System.out.println(((Supplier<Integer>)() -> {
            int max = arrs[0];
            for (int i = 1; i < arrs.length; i++) {
                if (arrs[i] > max)
                    max = arrs[i];
            }
            return max;
        }).get());
    }

    /**
     * 
     * 获取最大值
     * 
     */
    public static Integer getMax(Supplier<Integer> supplier) {

        return supplier.get();
    }
}
