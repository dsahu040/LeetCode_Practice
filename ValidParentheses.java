package top_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author Deep
 */
public class ValidParentheses {

    private static Map<Character, Character> map;

    static {
        map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                char top = stack.empty() ? '#' : stack.pop();
                
                if(top != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[{{}}][]()"));
    }
}