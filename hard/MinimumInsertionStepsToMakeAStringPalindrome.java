package hard;

class Solution {
    private int solve(String s, int[][] dp, int start, int end) {
        if (start == end)
            return 1;
        if (start > end)
            return 0;
        if (dp[start][end] != -1)
            return dp[start][end];

        if (s.charAt(start) == s.charAt(end)) {
            return 2 + solve(s, dp, start + 1, end - 1);
        }
        int leaveLeft = solve(s, dp, start + 1, end);
        int leaveRight = solve(s, dp, start, end - 1);

        return dp[start][end] = Math.max(leaveLeft, leaveRight);
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int ans = solve(s, dp, 0, s.length() - 1);
        return ans;
    }

    public int minInsertions(String s) {
        /**
         * keep the longest palindromic portion intact
         * part which is not palindrome add the reverse of it
         * eg - abcaa
         * aaa - longest palindromic portion, reverse(bc) - cb
         * add to string - abcacba => palindrome
         * 
         * aca - longest palindromic portion, reverse(ba) - ab
         * add to string - abAcaBa - AB are new additions
         * 
         * min insertions = n(length of the string) - (longest palindromic subsequence)
         * 
         * Pre- requiste problems - Longest Common Subsequence and Longest Palindromic
         * Subsequence
         */

        return s.length() - longestPalindromeSubseq(s);
    }
}