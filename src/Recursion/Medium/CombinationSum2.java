package Recursion.Medium;
/*
* Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
*
* */
import java.util.*;
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Sort the array to handle duplicates
        backtrack(0, candidates, curr, target, result);
        return result;
    }

    public void backtrack(int index, int[] candidates, List<Integer> curr, int targetLeft, List<List<Integer>> result) {
        if (targetLeft == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            // If the candidate exceeds the target, break out of the loop
            if (candidates[i] > targetLeft) break;

            // Include the candidate in the current combination
            curr.add(candidates[i]);
            // Recurse with the next index and reduced target
            backtrack(i + 1, candidates, curr, targetLeft - candidates[i], result);
            // Backtrack by removing the last added element
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();

        // Test case
        int[] candidates = {10, 1, 2, 7, 6, 5};
        int target = 8;

        List<List<Integer>> result = obj.combinationSum2(candidates, target);
        System.out.println(result); // Expected: [[1, 2, 5], [1, 7], [2, 6]]
    }
}
