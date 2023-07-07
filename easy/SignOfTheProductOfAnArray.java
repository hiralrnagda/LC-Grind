class Solution {
    public int arraySign(int[] nums) {
        int countNegative = 0;
        for (int n : nums) {
            if (n == 0) {
                return 0;
            }
            if (n < 0) {
                countNegative++;
            }
        }
        return countNegative % 2 == 0 ? 1 : -1;
    }
}