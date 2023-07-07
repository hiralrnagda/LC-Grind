class Solution {
    public int minCost(String colors, int[] neededTime) {
        int t = 0;
        int left = 0, right = 0;
        int n = neededTime.length;
        while (left < n && right < n) {
            int currTotal = 0, currMax = 0;

            while (right < n && colors.charAt(left) == colors.charAt(right)) {
                currTotal += neededTime[right];
                currMax = Math.max(currMax, neededTime[right]);
                right++;
            }

            t += currTotal - currMax;
            left = right;
        }
        return t;
    }
}