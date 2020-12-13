package top_100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
 * @author Deep
 */
public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0) {
            return result;
        }

        char[][] map = new char[8][];
        map[0] = "abc".toCharArray();
        map[1] = "def".toCharArray();
        map[2] = "ghi".toCharArray();
        map[3] = "jkl".toCharArray();
        map[4] = "mno".toCharArray();
        map[5] = "pqrs".toCharArray();
        map[6] = "tuv".toCharArray();
        map[7] = "wxyz".toCharArray();

        char[] inputDigits = digits.toCharArray();
        result.add("");

        for(char c : inputDigits) {
            List<String> next = new ArrayList<String>();
            for(String s: result) {
                for(char x: map[c - '2']) {
                    next.add(s+x);
                }
            }
            result = next;
        }

        return result;
    }

    public static void main(String[] args) {
       List<String> l = letterCombinations("234");
       
       l.forEach((n) -> System.out.println(n)); 
    }
}