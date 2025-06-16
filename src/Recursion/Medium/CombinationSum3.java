package Recursion.Medium;
/*
* Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
* */
import java.util.*;
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Set<List<Integer>> uniqueCom = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        helper(0, k, n, curr, uniqueCom, arr);
        return new ArrayList<>(uniqueCom);
    }

    public void helper(int index, int k, int n, List<Integer> curr, Set<List<Integer>> uniqueCom, int[] arr) {
        if (curr.size() == k && n == 0) {
            uniqueCom.add(new ArrayList<>(curr));
            return;
        }
        if (n < 0 || index == arr.length) return;

        curr.add(arr[index]);
        helper(index + 1, k, n - arr[index], curr, uniqueCom, arr);
        curr.remove(curr.size() - 1);
        helper(index + 1, k, n, curr, uniqueCom, arr);
    }

    public static void main(String[] args) {
        CombinationSum3 obj = new CombinationSum3();

        // Test case
        int k = 3, n = 7;
        List<List<Integer>> result = obj.combinationSum3(k, n);
        System.out.println(result);  // Expected: [[1, 2, 4]]
    }
}
