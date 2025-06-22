package Sliding_Window;
/*
* Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
* */
import java.util.*;
public class LongestSubWithoutRep {
    public static int lengthOfLongestSubstring(String s){
        int ans =0;
        int l =0;
        Set<Character> hs = new HashSet<>();
        for(int r=0;r<=s.length()-1;r++){
            char ch = s.charAt(r);
            if(!hs.contains(ch)) {
                hs.add(ch);
            }else{
                while(hs.contains(ch)){
                    hs.remove(s.charAt(l));
                    l++;
                }
                hs.add(ch);
            }
            ans= Math.max(ans,r-l+1);
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }
}
