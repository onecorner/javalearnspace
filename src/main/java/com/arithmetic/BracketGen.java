package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhons on 2018/9/3.
 */
public class BracketGen {
    public static void main(String[] args) {
        Solution1 so = new Solution1();
        List<String> strings = so.generateParenthesis(3);
        System.out.println(strings);
    }
}

class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
