class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, 0, nums, target);
    }

    private int solve(int index, int sum, int nums[], int target) {
        if (index == nums.length) {
            if (target == sum)
                return 1;
            else
                return 0;
        }
        return solve(index + 1, sum + nums[index], nums, target) +
                solve(index + 1, sum - nums[index], nums, target);
    }
}