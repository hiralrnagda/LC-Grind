class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];

            if (temp == sum)
                return i;

            temp += nums[i];
        }
        return -1;
    }
}