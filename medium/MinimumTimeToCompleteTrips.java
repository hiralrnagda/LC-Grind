class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long min = time[0];
        for (int t : time) {
            min = Math.min(min, t);
        }
        long right = min * totalTrips;
        while (left < right) {
            long mid = (left + (right - left) / 2);

            // how many trips we could do
            long total = totalTripInGivenTime(time, mid);

            // we cannot reach the total number of trips - mid is too small
            if (total < totalTrips) {
                left = mid + 1;
            } else {
                // we can reach total number of trips but we want right to be as small as
                // possible
                right = mid;
            }
        }
        return left;
    }

    private long totalTripInGivenTime(int[] time, long givenTime) {
        long totalTrips = 0l;
        for (int t : time) {
            totalTrips += ((long) givenTime) / t;
        }
        return totalTrips;
    }
}