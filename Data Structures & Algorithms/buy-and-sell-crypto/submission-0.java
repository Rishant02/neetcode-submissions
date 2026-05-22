class Solution {
    public int maxProfit(int[] prices) {

        /*
         * Intuition:
         * We need to maximize:
         *
         * selling price - buying price
         *
         * To get maximum profit:
         * - buy at the minimum price seen so far
         * - sell at current price
         *
         * We iterate through the array once while maintaining:
         *
         * minPrice -> lowest buying price encountered till now
         * profit   -> maximum profit achievable till current day
         *
         * At every step:
         * 1. Update minimum buying price
         * 2. Calculate profit if sold today
         * 3. Update maximum profit
         *
         * TC: O(n)
         * SC: O(1)
         */

        // Stores maximum profit possible
        int profit = 0;

        // Minimum stock price seen so far (best day to buy)
        int minPrice = prices[0];

        for (int price : prices) {

            // Update minimum buying price
            minPrice = Math.min(price, minPrice);

            /*
             * Profit if:
             * - bought at minPrice
             * - sold today at current price
             */
            profit = Math.max(profit, price - minPrice);
        }

        return profit;
    }
}