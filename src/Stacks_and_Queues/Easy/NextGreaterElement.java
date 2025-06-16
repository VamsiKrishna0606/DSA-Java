/**
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 */
package Stacks_and_Queues.Easy;
import java.util.*;
class NextGreaterElement {
    public static int[] nextGrtElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums2.length;

        //n-1 to 0
        for (int i = n - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!st.isEmpty() && num <=st.peek()) {
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
        int[] result = nextGrtElement(nums1,nums2);
        System.out.println(Arrays.toString(result));

    }
}
