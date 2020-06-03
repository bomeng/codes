package solution_714;

public class Solution {

    public int maxProfit(int[] prices, int fee) {
        // cost[][] will be balance, cost[][0]
        // cost[][0] is balance amount and you are holding a stock after ith day.
        // cost[][1] is balance amount and you are not-holding a stock after ith day.

        // states
        // -------------------------------
        // holding -> holding [DO-NOTHING]
        // holding -> not-holding [SELL]
        // not-holding -> not holding [DO-NOTHING]
        // not-holding -> holding [BUY]

        int[][] cost = new int[prices.length][2];

        cost[0][0] = -prices[0]; // you are buying stock at day 0
        cost[0][1] = 0;        // you are not-buying stock at day 0

        for (int i = 1; i < prices.length; i++) {
            //                        SKIP           BUY
            cost[i][0] = Math.max(cost[i - 1][0], cost[i - 1][1] - prices[i]);
            //                        SKIP             SELL
            cost[i][1] = Math.max(cost[i - 1][1], cost[i - 1][0] + prices[i] - fee);
        }

        return cost[prices.length - 1][1]; // last day - you should not hold a stock
    }
}
