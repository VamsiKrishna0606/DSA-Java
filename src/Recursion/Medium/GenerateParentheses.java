package Recursion.Medium;
/*
*
* Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
* */
import java.util.*;
public class GenerateParentheses {
    public List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    public void generate(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) {
            generate(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            generate(result, current + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        // Test case
        List<String> result = obj.generateParentheses(3);
        System.out.println(result);  // Expected: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
}
