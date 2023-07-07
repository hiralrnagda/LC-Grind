class Solution {
    private boolean canShipCargo(int weights[], int max, int days) {
        int load = 0;
        int countDays = 1;

        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > max) {
                countDays++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return countDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        /**
         * BINARY SEARCH ON ANSWER
         * the range would be low = max(weights) and high = sum of all elements in
         * weights
         * helper func to find if it is feasible to ship load in D days
         */

        int max = 0, sum = 0;
        for (int n : weights) {
            max = Math.max(n, max);
            sum += n;
        }

        int low = max, high = sum;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShipCargo(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}