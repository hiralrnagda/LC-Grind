import java.util.*;

class Solution {
    // Aproach 1 - memoization
    public int longestCommonSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return f(m - 1, n - 1, s, t, dp);
    }

    private int f(int i, int j, String s, String t, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        // if match
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + f(i - 1, j - 1, s, t, dp);
        }

        // does not match
        return dp[i][j] = Math.max(f(i - 1, j, s, t, dp), f(i, j - 1, s, t, dp));
    }
}