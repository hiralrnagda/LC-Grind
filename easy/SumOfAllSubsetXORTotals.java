package easy;

class Solution {
    /*
     * - Generate all subsets
     * - XOR all elements while generating subsets
     * - return totalXOR sum
     */
    private int solve(int nums[], int ind, int xorSum) {
        if (ind == nums.length)
            return xorSum;

        int include = solve(nums, ind + 1, xorSum ^ nums[ind]);

        int exclude = solve(nums, ind + 1, xorSum);

        return include + exclude;
    }

    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }
}