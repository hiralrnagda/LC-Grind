class Solution {
    // Maximum Sum of Non-Adjacent Elements
    // TC: O(N), SC: O(1)
    // public int rob(int[] nums) {
    // int n = nums.length;
    // for(int i = 1; i < n; i++)
    // {
    // if(i == 1){
    // nums[i] = Math.max(nums[i], nums[i - 1]);
    // }
    // else
    // {
    // nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
    // }
    // }
    // return nums[n - 1];
    // }
    int dp[];

    public int rob(int nums[]) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return solve(nums.length - 1, nums);
    }

    private int solve(int i, int nums[]) {
        if (i < 0)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        return dp[i] = Math.max(solve(i - 2, nums) + nums[i], solve(i - 1, nums));
    }
}