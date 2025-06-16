package Recursion.Medium;
/*
* Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
* */
import java.util.*;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(0, candidates, target, current, result);
        return result;
    }

    public void helper(int index, int[] candidates, int targetLeft, List<Integer> current, List<List<Integer>> result) {
        if (targetLeft == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index == candidates.length || targetLeft < 0) return;

        // Include the current candidate
        current.add(candidates[index]);
        helper(index, candidates, targetLeft - candidates[index], current, result);

        // Exclude the current candidate and move to the next one
        current.remove(current.size() - 1);
        helper(index + 1, candidates, targetLeft, current, result);
    }

    public static void main(String[] args) {
        CombinationSum1 obj = new CombinationSum1();

        // Test case
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = obj.combinationSum(candidates, target);
        System.out.println(result); // Expected: [[2, 2, 3], [7]]
    }
}

