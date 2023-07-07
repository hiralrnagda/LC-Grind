class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        res[0] = 1;
        // build the left hand array
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // build right hand array
        int rightCounter = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightCounter;
            rightCounter *= nums[i];
        }
        return res;
    }
}