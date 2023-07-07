class Solution {
    private int helper(int ind, int coins[], int t, int dp[][]) {
        // unbounded knapsack
        // base case is very important to understand
        // agar ind == 0 hai
        // arr[0] = 4 and T = 12 then return 1
        if (ind == 0) {
            if (t % coins[ind] == 0) {
                return 1;
            } else
                return 0;
        }
        if (dp[ind][t] != -1) {
            return dp[ind][t];
        }

        int notTake = helper(ind - 1, coins, t, dp);
        int take = 0;
        if (coins[ind] <= t) {
            take = helper(ind, coins, t - coins[ind], dp);
        }

        return dp[ind][t] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return helper(n - 1, coins, amount, dp);
    }
}