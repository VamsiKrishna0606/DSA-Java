/*
You write a love letter to your friend. However, before your friend can read it,
someone else takes it and rotates the characters of each word from left to right
K times.
Your task is to determine how many of the words still remain the same even after
this rotation.
Input Format:
-------------
input1: A string containing words separated by spaces.
input2: An integer K indicating the number of right rotations for each word.
Output Format:
--------------
An integer representing the number of words that remain unchanged after K right
rotations.
Sample Input:
-------------
ramram santan nnnn
3
Sample Output:
--------------
2
ram
Sample Input:
-------------
adasda
3
Sample Output:
--------------
0
 */

package FS;
import java.util.*;
public class Program20625 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String[] s = sc.nextLine().split(" ");
            int k = sc.nextInt();
            int count=0;
            for(String str: s){
                if(isSame(str,k)){
                    count++;
                }
            }
            System.out.println(count);
        }
        public static  boolean isSame(String s,int k){
            StringBuilder sb = new StringBuilder(s);
            int len = sb.length();
            k=k%len;
            for(int i=0;i<k;i++){
                char last = sb.charAt(len-1);
                sb.deleteCharAt(len-1);
                sb.insert(0,last);
            }
            return s.equals(sb.toString());
        }
    }
