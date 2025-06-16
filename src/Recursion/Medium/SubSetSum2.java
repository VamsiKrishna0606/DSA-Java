package Recursion.Medium;
/*
* Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
* */
import java.util.*;
public class SubSetSum2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> uniqueSubs = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, curr, uniqueSubs);
        return new ArrayList<>(uniqueSubs);
    }

    public void helper(int index, int[] nums, List<Integer> curr, Set<List<Integer>> uniqueSubs) {
        if (index == nums.length) {
            uniqueSubs.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        helper(index + 1, nums, curr, uniqueSubs);
        curr.remove(curr.size() - 1);
        helper(index + 1, nums, curr, uniqueSubs);
    }

    public static void main(String[] args) {
        SubSetSum2 obj = new SubSetSum2();

        // Test case
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = obj.subsetsWithDup(nums);
        System.out.println(result); // Expected: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }
}
