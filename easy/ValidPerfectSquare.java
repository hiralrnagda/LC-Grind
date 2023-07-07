class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2)
            return true;
        long left = 2;
        long right = num / 2;

        while (left <= right) {
            long x = left + (right - left) / 2;
            if (x * x == num) {
                return true;
            } else if (x * x < num) {
                left = x + 1;
            } else {
                right = x - 1;
            }
        }
        return false;
    }
}