package com.arithmetic;

import java.util.Arrays;

/**
 * Created by jhons on 2018/9/3.
 */
public class RemoveElements {
    public static void main(String[] args) {
        int arry[] = new int[]{1, 2, 3, 4, 5, 6, 1, 2, 1};
        removeElement(arry, 1);
        System.out.println(Arrays.toString(arry));

    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums)+"--->"+n);
        return n;
    }


}
