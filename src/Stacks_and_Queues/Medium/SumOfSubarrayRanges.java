package Stacks_and_Queues.Medium;
/*
Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
*/
import java.util.Scanner;

public class SumOfSubarrayRanges {
    public static  long subArrayRanges(int[] nums) {
        long range=0;
        for(int i=0;i<nums.length;i++){
            int min =Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=i;j<nums.length;j++){
                min = Math.min(min,nums[j]);
                max = Math.max(max,nums[j]);
                range+=(max-min);
            }
        }
        return range;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        long result = subArrayRanges(nums);
        System.out.println(result);
    }
}
