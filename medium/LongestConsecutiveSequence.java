class Solution {
    public int longestConsecutive(int[] nums) {
        int size = nums.length;
        if (size == 0)
            return 0;
        int longest = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(nums[i]);
        }

        for (int n : set) {
            // ensuring we start from the start of the subsequence
            if (!set.contains(n - 1)) {
                int count = 1;
                int x = n;
                // now checking for consecutive
                while (set.contains(x + 1)) {
                    count += 1;
                    x += 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}