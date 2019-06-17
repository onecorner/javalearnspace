package com.bytesdemo;

import java.io.UnsupportedEncodingException;

/*
* @since:       created in  2019-01-22 17:18
* @author:      htj
* @modified by:
* @version:     1.1
*/
public class ByteLearn {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "中国";
        System.out.println(s.getBytes("unicode"));
        System.out.println(new String(s.getBytes("unicode"),"unicode"));
        String[] strs =  {"a", "b", "c"};
        System.out.println(strs.length);
    }
}
