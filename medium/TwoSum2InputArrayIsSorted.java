class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int x = numbers[left] + numbers[right];

            if (x > target) {
                right--;
            } else if (x < target) {
                left++;
            } else if (x == target) {
                int result[] = { left + 1, right + 1 };
                return result;
            }
        }
        return new int[0];
    }
}