package Sliding_window;


public class Problem_15 {

    // ----------------------------------------------------
    // Approach 1: Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    //
    // Idea:
    // Try all possible buy (i) and sell (j) pairs
    // Calculate profit for each pair and track the maximum
    // ----------------------------------------------------
    public int maxProfit(int[] prices) {
        int result = 0;

        // Pick a buying day
        for (int i = 0; i < prices.length; i++) {

            // Pick a selling day AFTER buying day
            for (int j = i + 1; j < prices.length; j++) {

                int profit = prices[j] - prices[i];
                result = Math.max(result, profit);
            }
        }
        return result;
    }

    // ----------------------------------------------------
    // Approach 2: Two Pointer (Optimized)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //
    // left  -> buying day
    // right -> selling day
    //
    // If price[right] < price[left],
    // then it is a better buying opportunity,
    // so move left to right
    // ----------------------------------------------------
    public int maxProfit1(int[] prices) {

        int left = 0;   // Buy pointer
        int right = 1;  // Sell pointer
        int profit = 0;

        while (right < prices.length) {

            // If selling price is higher than buying price
            if (prices[right] > prices[left]) {

                profit = Math.max(profit, prices[right] - prices[left]);
            }
            // If we find a cheaper price, update buying day
            else {
                left = right;
            }

            // Always move right forward
            right++;
        }
        return profit;
    }

    // ----------------------------------------------------
    // Approach 3: Greedy One-Pass (Most Clean)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //
    // Idea:
    // Keep track of:
    // 1) Minimum buying price so far
    // 2) Maximum profit so far
    // ----------------------------------------------------
    public int maxProfit2(int[] prices) {

        int minBuy = prices[0]; // Lowest price seen so far
        int maxProfit = 0;

        for (int sellingPrice : prices) {

            // Try selling at current price
            maxProfit = Math.max(maxProfit, sellingPrice - minBuy);

            // Update minimum buying price if found cheaper
            minBuy = Math.min(minBuy, sellingPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test cases can be added here
    }
}
