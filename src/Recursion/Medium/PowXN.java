package Recursion.Medium;
/*
* Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
* */
public class PowXN {
    public double myPow(double x, int n) {
        long pow = n;
        if (pow < 0) {
            x = 1 / x;
            pow = -pow;
        }
        return power(x, pow);
    }

    public double power(double x, long pow) {
        if (pow == 0) return 1;

        double half = power(x, pow / 2);
        if (pow % 2 == 0) return half * half;
        else return half * half * x;
    }

    public static void main(String[] args) {
        PowXN obj = new PowXN();

        // Test cases
        System.out.println(obj.myPow(2.0, 10));  // Expected: 1024.0
        System.out.println(obj.myPow(2.0, -2));  // Expected: 0.25
        System.out.println(obj.myPow(3.0, 3));   // Expected: 27.0
    }
}
