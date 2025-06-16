package Stacks_and_Queues.Medium;
import java.util.*;
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch: num.toCharArray()){
            int n = ch -'0';
            while(!st.isEmpty() && st.peek()>n && k>0){
                st.pop();
                k--;
            }
            st.push(n);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        for(int i:st){
            sb.append(i);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length()==0?"0":sb.toString();
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        System.out.println(removeKdigits(str,k));

    }
}
