class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int m = rolls.length;
        int sumM = 0;

        for (int i : rolls) {
            sumM += i;
        }
        int x = mean * (m + n) - sumM;
        if (x <= 0 || n * 6 < x || ((x / n) == 0)) {
            return new int[] {};
        }

        int res[] = new int[n];
        int p = x / n, q = x % n;

        for (int i = 0; i < n; i++) {
            res[i] = p + (q > 0 ? 1 : 0);
            q--;
        }
        return res;
    }
}