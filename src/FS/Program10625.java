package FS;
import java.util.*;
public class Program10625 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            int[] ans = new int[n];
            //k loop says... take 1 size sub arrays , next 2 size... next n size
            for(int k=1;k<=n;k++){
                int max = Integer.MIN_VALUE;
                //i iterates through all elements in that subarray... starts from 0 till window size n-k+!
                for(int i=0;i<n-k+1;i++){
                    int min = Integer.MAX_VALUE;
                    //two pointer to iterate trhough all elements in those subarrays ... the i and j
                    for(int j=i;j<i+k;j++){
                        min = Math.min(min,arr[j]);
                    }
                    max = Math.max(max,min);
                }
                ans[k-1]=max;
            }
            for(int nums:ans){
                System.out.print(nums+" ");
            }
        }
    }

