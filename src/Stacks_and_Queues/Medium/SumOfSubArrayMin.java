package Stacks_and_Queues.Medium;
import java.util.*;
public class SumOfSubArrayMin {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            while (!st.isEmpty() && arr[st.peek()] > num) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            while (!st.isEmpty() && arr[st.peek()] >= num) {
                st.pop();
                }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
            }

        long total =0;
        for(int i=0;i<n;i++){
            int left = i - pse[i];
            int right = nse[i]-i;
            total = (total + (long) arr[i] * left * right)%mod;
        }
        return (int) total;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for(int i=0;i<input.length;i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        System.out.println(sumSubarrayMins(arr));
    }
}
