class Solution {
    public int dominantIndex(int[] nums) {
        // maintain the max integer as well as maxIndex in 2 var, - 1st scan
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        // 2nd scan - check if current element is not the max element and max < 2 *
        // current element => return -1
        // else return maxIndex
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max && max < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }
}