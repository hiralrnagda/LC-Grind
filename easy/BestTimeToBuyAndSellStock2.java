class Solution {
    // DP approach - TLE
    // private int helper(int index, int buy, int prices[], int n, int dp[][])
    // {
    // int profit = 0;
    // if(index == n) return 0;

    // if(buy == 1)
    // {
    // profit = Math.max(
    // -prices[index] + helper(index + 1, 0, prices, n, dp),
    // 0 + helper(index + 1, 1, prices, n, dp));
    // }
    // else
    // {
    // profit = Math.max(
    // prices[index] + helper(index + 1, 1, prices, n, dp),
    // 0 + helper(index + 1, 0, prices, n, dp));
    // }

    // return profit;
    // }
    // public int maxProfit(int[] prices) {
    // int n = prices.length;
    // int dp[][] = new int[n][2];
    // Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
    // return helper(0, 1, prices, n, dp);
    // }
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}