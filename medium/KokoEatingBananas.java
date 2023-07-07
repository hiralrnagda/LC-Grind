class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int k = left + (right - left) / 2;
            int hours = 0;

            for (int pile : piles) {
                hours += Math.ceil((double) pile / k);
            }

            if (hours <= h) {
                right = k;
            } else {
                left = k + 1;
            }
        }
        return left;
    }
}