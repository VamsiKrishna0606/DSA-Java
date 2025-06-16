package Stacks_and_Queues.Medium;
/*
* Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
* */
import java.util.*;
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean destroyed=false;
            int num = arr[i];
            while(!st.isEmpty() && num<0 && st.peek()>0){
                if(st.peek()<-num) st.pop();
                else if(st.peek()==-num) {
                    st.pop();
                    destroyed = true;break;
                }else{
                    destroyed=true;break;
                }
            }
            if(!destroyed) st.push(num);
        }
        while(!st.isEmpty()) list.add(st.pop());
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] result = asteroidCollision(arr);
        System.out.println(Arrays.toString(result));
    }
}
