package Stacks_and_Queues.Easy;

import java.util.*;

public class PreviousSallerElement {
    public static int[] prevSmallerElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums2.length;

        // Traverse nums2 and fill the map with next greater element for each element in nums2
        for (int i =0; i<n; i++) {
            int num = nums2[i];
            while (!st.isEmpty() && num <= st.peek()) {
                st.pop();  // Remove smaller or equal elements from the stack
            }
            if (st.isEmpty()) {
                hm.put(num, -1);  // If stack is empty, no greater element
            } else {
                hm.put(num, st.peek());  // The next greater element is at the top of the stack
            }
            st.push(num);  // Push the current element onto the stack
        }

        // For each number in nums1, find its next greater element from the map
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hm.getOrDefault(nums1[i], -1);  // Default to -1 if no next greater element
        }

        return nums1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        int[] nums1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            nums1[i] = Integer.parseInt(input1[i]);
        }
        String[] input2 = sc.nextLine().split(" ");
        int[] nums2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            nums2[i] = Integer.parseInt(input2[i]);
        }
        int[] result = prevSmallerElement(nums1,nums2);
        System.out.println(Arrays.toString(result));

    }
}
