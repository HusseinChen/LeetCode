package com.hussein.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

 * @author: hsc13668
 * @E-mail：housongchen@noahgroup.com
 * @Date 2019/10/7 14:57
 */
public class LeetCode20 {

    private static HashMap<Character, Character> mappings;

    static  {
        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    /**
     * @Description: 栈+分治的思想，开符号入栈，遇到闭符号出栈
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/10/7-16:10
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // @Description: 非闭符号，入栈 hsc13668
            if (mappings.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()()(){[(]]}";
        System.out.println(isValid(s));
    }
}
