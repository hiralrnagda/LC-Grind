class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = arr.length - 1;
        int missingNumber = compute(arr[right], n);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            missingNumber = compute(arr[mid], mid + 1);

            if (missingNumber >= k)
                right = mid - 1;
            else
                left = mid + 1;
        }

        if (right == -1) {
            return k;
        }
        return arr[right] + k - compute(arr[right], right + 1);
    }

    private int compute(int actual, int expected) {
        return actual - expected;
    }
}