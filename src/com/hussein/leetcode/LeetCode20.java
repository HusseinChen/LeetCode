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

    private static HashMap<Character, Character> mappings = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    /**
     * @Description: 利用栈，有点类似分治的思想，开符号入栈，遇到闭符号出栈，
     *              如果是有效字符串的话去掉一组符号，他的子结构也应该是有效字符串
     *              并且有效字符串的结构一定是成对的，最终栈内一定为空
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/10/7-16:10
     */
    public static boolean isValid1(String s) {
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

    private static int top = -1;
    private static char[] stack;

    /**
     * @Description: 其实还是利用了栈的思想，但是结构更加简单，通过数组去维护一个栈
     *              因为我只需要记录头节点，不需要记录下一节点，所以相比用java栈的执行速度会更快
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return: 
     * @Date 2019/10/8-16:01
     */
    public static boolean isValid2(String s) {
        stack = new char[s.length()];
        for (char c : s.toCharArray()) {
            if (!mappings.containsKey(c)) {
                push(c);
            } else {
                try {
                    char pop = pop();
                    if (pop != mappings.get(c)) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        if (top >= 0) {
            return false;
        }
        return true;
    }

    public static void push(char c) {
        top++;
        stack[top] = c;
    }

    public static char pop() throws Exception {
        if (top < 0) {
            throw new Exception("underflow");
        }
        char c = stack[top];
        top--;
        return c;
    }

    /**
     * @Description: 替换通过hash检索而已，但其实还没有hash检索快哦，哈哈哈哈
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/10/8-16:30
     */
    public static boolean match(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "[";
        System.out.println(isValid2(s));
    }
}
