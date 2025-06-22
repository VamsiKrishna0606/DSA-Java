package Arrays.Medium;

import java.util.*;

public class TwoSum {
        public static int[] twoSum(int[] nums, int target) {
            int l=0;
            int r=0;
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    if((nums[i]+nums[j])==target){
                        l=i;
                        r=j;
                        break;
                    }
                }
            }
            return new int[]{l,r};
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] res = twoSum(arr,target);
        System.out.println(Arrays.toString(res));
    }
}
