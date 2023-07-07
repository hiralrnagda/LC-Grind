class Solution {
    public int maxProduct(int[] nums) {
        /**
         * Brute force - TC - O(n3), SC - O()
         */
        // leftProduct = prefixProduct and rightProduct = suffixProduct
        int leftProduct = 1, rightProduct = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (leftProduct == 0)
                leftProduct = 1;
            if (rightProduct == 0)
                rightProduct = 1;

            leftProduct *= nums[i];
            rightProduct *= nums[n - i - 1];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return ans;
    }
}