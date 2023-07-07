class Solution {
    private static boolean isPossibleToMakeBouquet(int bloomDay[], int day, int m, int k) {
        int count = 0, countBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++; // flower can be picked
            } else
            // flower cannot be picked
            {
                // update the bouquet count and make count = 0 - because we want pick adjacent
                // flowers
                countBouquets += count / k;
                count = 0;
            }
        }
        countBouquets += count / k;
        return countBouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int ans = -1;
        if (bloomDay.length < m * k)
            return ans;
        int low = 0, high = 0;
        for (int n : bloomDay) {
            low = Math.min(low, n);
            high = Math.max(high, n);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleToMakeBouquet(bloomDay, mid, m, k)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}