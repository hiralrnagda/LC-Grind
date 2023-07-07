class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;

        // when the array is rotated n times - is completely sorted - in ascending order
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[low] < nums[mid]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid - 1;
            }
        }
        return -1;
    }
}