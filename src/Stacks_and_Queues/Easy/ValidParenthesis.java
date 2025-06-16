package Stacks_and_Queues.Easy;
/*
* Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
Example 4:
Input: s = "([])"
Output: true
* */
import java.util.*;
public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack <Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='[' || ch == '{' || ch== '('){
                st.push(ch);
            }else{
                if(st.isEmpty() ||
                        (ch==')' && st.pop()!='(') ||
                        (ch==']' && st.pop()!='[') ||
                        (ch=='}' && st.pop()!='{')){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }
}
