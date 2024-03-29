// Best Time to Buy and Sell Stock

 

// Say you have an array for which the ith element is the price of a given stock on day i.

 

// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),

// design an algorithm to find the maximum profit.

 

// Note that you cannot sell a stock before you buy one.

 

// Example 1:

 

// Input: [7,1,5,3,6,4]

// Output: 5

// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

// Not 7-1 = 6, as selling price needs to be larger than buying price.

// Example 2:

 

// Input: [7,6,4,3,1]

// Output: 0

// Explanation: In this case, no transaction is done, i.e. max profit = 0.

import java.util.*;

public class StockSell {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of stocks: ");
        int n = in.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++) prices[i] = in.nextInt();
        System.out.print(calProfit(prices));
        
    }
    public static int calProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        int maxProfit = 0,min = Integer.MAX_VALUE;
        for(int i =0;i<prices.length;i++){
            if(prices[i]<min) min = prices[i];
            else if(prices[i]>min) maxProfit = Math.max(prices[i]-min,maxProfit);
        }
        return maxProfit;
    }

    
}
