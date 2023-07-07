class Solution {
    // approach 1
    // public int findDuplicate(int[] nums) {
    // int slow = nums[0];
    // int fast = nums[0];
    // do
    // {
    // slow = nums[slow];
    // fast = nums[nums[fast]];
    // }
    // while(slow != fast);

    // fast = nums[0];
    // while(slow != fast)
    // {
    // slow = nums[slow];
    // fast = nums[fast];
    // }

    // return slow;
    // }

    // brute force approach - 2 for loops
    // better solution - use hashset
    // optimal solution
    // approach 2: create a hash function based on the element in array and map to
    // a[i] - 1 in the array
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // negate the existing elements whichever element is already found
                                               // negative is the duplicate
            if (nums[index] < 0) {
                duplicate = Math.abs(nums[i]);
                break;
            }
            nums[index] = -nums[index];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return duplicate;
    }
}