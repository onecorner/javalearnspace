package com.stringlearn;

import java.util.Arrays;

/**
 * @ClassName StringReverseDemo
 * @since: created in  2019-03-07 14:01
 * @author: htj
 * @modified by:
 * @version: 1.1
 **/
public class StringReverseDemo {
    public static boolean isPalindRome(String str) {
        if (str == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString().equals(str);
    }

    public static boolean isPalindromeString(String str) {
        if (str == null) {
            return false;
        }
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            if (str.charAt(i) != str.charAt(strLength - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // 回文
        // 工具类回文
        System.out.println(isPalindRome("abcba"));
        // 原生回文程序
        System.out.println(isPalindromeString("abcdcbc"));
        char c = 'z';
        System.out.println((int) c);
        System.out.println((int) 'Z');
        System.out.println(toUpperCase("abfG------dfd"));
        System.out.println(Arrays.toString(new int[]{1,2,3,4,5,}));

        testEquals();
        testIntern();
    }

    private static void testEquals() {
        String s1 = "abc";
        StringBuffer s2 = new StringBuffer(s1);
        // false 这里因为string会进行类型判断
        System.out.println(s1.equals(s2));


        String s3 = "abc";
        String s4= new String("abc");
        // true
        System.out.println("s3 equals s4 ? "+(s3.equals(s4)));
    }

    private static void testIntern() {
        String s1 = "abc";
        String s2 = new String("abc");
        s2.intern();
        // false 因为没有分配
        System.out.println(s1 ==s2);
        s2 = s2.intern();
        // true
        System.out.println(s1 ==s2);
    }

    /**
     * 小写的字母(a~z)是在97~122之间
     * 大写的字母(A~Z)是在65~90之间 大小写之间相差了32
     **/
    public static String toUpperCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < str.length(); index++) {
            int charAtIndex = (int) str.charAt(index);
            //是小写
            if (charAtIndex >= 97 && charAtIndex <= 122) {
                charAtIndex = charAtIndex - 32;

            }
            sb.append((char) charAtIndex);
        }
        return sb.toString();
    }
}
