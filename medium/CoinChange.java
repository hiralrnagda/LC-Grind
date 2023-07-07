class Solution {
    private int helper(int ind, int coins[], int t, int dp[][]) {
        // base case is very important to understand
        // agar ind == 0 hai
        // arr[0] = 4 and T = 12 then return 1
        if (ind == 0) {
            if (t % coins[ind] == 0) {
                return t / coins[ind]; // number of coins required to make the t
            }
            return Integer.MAX_VALUE;
        }
        if (dp[ind][t] != -1) {
            return dp[ind][t];
        }

        int notTake = 0 + helper(ind - 1, coins, t, dp);
        int take = Integer.MAX_VALUE - 1;
        if (coins[ind] <= t) {
            take = 1 + helper(ind, coins, t - coins[ind], dp);
        }

        return dp[ind][t] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        int ans = helper(n - 1, coins, amount, dp);
        if (ans != Integer.MAX_VALUE) {
            return ans;
        } else {
            return -1;
        }
    }

    // using BFS
    // public int coinChange(int coins[], int amount)
    // {
    // Queue<Integer> q = new LinkedList<>();
    // q.add(0);
    // int cs = 0;
    // boolean[] vstd = new boolean[amount+1];
    // while(!q.isEmpty()) {
    // int n = q.size();
    // for(int i=0;i<n;i++) {
    // int sum = q.poll();
    // if(sum==amount) {
    // return cs;
    // }
    // if(sum>amount || vstd[sum]) {
    // continue;
    // }
    // vstd[sum]=true;
    // for(int coin:coins) {
    // q.add(sum+coin);
    // }
    // }
    // cs++;
    // }
    // return -1;
    // }
}