class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int c = 0;
        for (int num : nums) {
            c = c ^ num; // XOR operation cancels the same number making c 0,
                         // thus the only single number is saved in c at the end
        }
        return c;
    }
}