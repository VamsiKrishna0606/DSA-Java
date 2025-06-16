package Recursion.Medium;
/*
* Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
* */
import java.util.*;

public class LetterPhoneCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder curr = new StringBuilder();
        List<String> ans = new ArrayList<>();
        helper(0, digits, map, curr, ans);
        return ans;
    }

    public void helper(int index, String digits, String[] map, StringBuilder curr, List<String> ans) {
        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            curr.append(c);
            helper(index + 1, digits, map, curr, ans);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterPhoneCombinations obj = new LetterPhoneCombinations();

        // Test case
        String digits = "23";
        List<String> result = obj.letterCombinations(digits);
        System.out.println(result);  // Expected: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }
}

