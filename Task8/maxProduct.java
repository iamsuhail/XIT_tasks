// Given an integer n, break into  the sum of k positive integers, and return the maximum product of those integers.

// Input:

// Integer n

 

// Desired Output:

// Maximum product of numbers whose sum is n.

 

// Example 1:

 

// n=5;

 

// 5 can be written as sum of following numbers.

 

// Possible Sums:

// 1.            1+1+1+1+1,

// 2.            1+4,

// 3.            1+1+3,

// 4.            1+1+1+2,

// 5.            2+3,

// 6.            1+2+2.....etc

// Product of these integers:

// 1.            1*1*1*1*1=1,

// 2.            1*4=4,

// 3.            1*1*3=3,

// 4.            1*1*1*2=2

// 5.            2*3=6,

// 6.            1*2*2=4.....etc

// Output returned should be maximum product which in the above case is 6.

 

 

// Example 2:

 

// n=10;

// Desired Output : 36

// Integers : 3,3,4 or 3,3,2,2

import java.util.*;
public class maxProduct{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        System.out.println(maxProduct(n));
    }
    public static int maxProduct(int n) { // Time complexity - O(N^2) & Space complexity - O(N)
        // using dp
        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
    public int maxProduct2(int n) { // Time complexity - O(N) & Space complexity - O(1)
        // using greedy algo
        if(n==2) return 1;
        if(n==3) return 2;
        if(n==4) return 4;
        int maxPro =1;
        while(n>4){
            maxPro*=3;
            n-=3;
        }
        maxPro*=n;
        return maxPro; 
    }

}