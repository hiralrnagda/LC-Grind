class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            currSum = Math.max(0, currSum) + nums[i];
            maxSum = Math.max(currSum, maxSum);
        }
        
        return maxSum;
    }
}