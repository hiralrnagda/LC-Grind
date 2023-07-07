class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroElement = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroElement++] = nums[i];
            }
        }
        for (int i = lastNonZeroElement; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}