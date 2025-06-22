package Sliding_Window;
/*
* Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
Example :
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
* */
import java.util.*;
public class MaxConsecutivesOnes {
    public static int longestOnes(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        int temp = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) temp++;
            while (temp > k) {
                if (nums[l] == 0) temp--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(longestOnes(nums,k));

    }
}
