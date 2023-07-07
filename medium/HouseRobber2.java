class Solution {
    private int helper(int[] nums) {

        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                nums[i] = Math.max(nums[i], nums[i - 1]);
            } else {
                nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
            }
        }
        return nums[n - 1];
    }

    public int rob(int[] nums) {
        // here the logic is similar - we are applying Hiuse Robber 1 on nums[0,... n -
        // 2] and on nums[1,..., n - 1] and then taking max of both
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int n = nums.length;
        int temp1[] = new int[n];
        int temp2[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                temp1[i] = nums[i];
            }
            if (i != n - 1) {
                temp2[i] = nums[i];
            }
        }

        return Math.max(helper(temp1), helper(temp2));
    }
}