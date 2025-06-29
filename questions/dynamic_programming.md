## Q1. You are given an array prices where `prices[i]` is the price of a given stock on the `ith` day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

*leetcode - [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)*

```
Examples:

    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    
    
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.

```

### Approach 1: Brute Force

**Step 1:** Select a day and buy the stock.

**Step 2:** Select another day after stock is bought.

**Step 3:** Find profit and compare with the max achieved profit till now

```java
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)
```

### Approach 2: Optimal

**Step 1:** Assume minimum buying price is prices[0] - first day

**Step 2:** While traversing the prices array, use low & high to store prices

**Step 3:** if we have a even lower price, we update both low & high

**Step 4:** if we have a higher price, update only high

```java
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        int sell = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
                sell = prices[i];
            } else if (prices[i] > sell) {
                sell = prices[i];
            }
            maxProfit = Math.max(maxProfit, sell - buy);
        }
        
        return maxProfit;
        
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```








