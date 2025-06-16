package Stacks_and_Queues.Medium;
/*
* Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
* */
import java.util.*;
public class NextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n= nums.length;
        int[] nge = new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            nge[i%n] = st.isEmpty()?-1:st.peek();
            st.push(nums[i%n]);
        }
        return nge;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(input[i]);
        }
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }
}
