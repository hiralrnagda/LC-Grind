class Solution {
    public int[] sumZero(int n) {
        int res[] = new int[n];

        // odd size of res - I need 0
        if (n % 2 != 0) {
            int half = n / 2;
            int negativeHalf = -1 * (n / 2);
            for (int i = 0; i < n / 2; i++) {
                res[i] = half;
                res[n - 1 - i] = negativeHalf;
                half++;
                negativeHalf--;
            }
        } else
        // even size of res - I don't need 0
        {
            int half = n / 2;
            int negativeHalf = -1 * (n / 2);
            for (int i = 0; i < n / 2; i++) {
                if (half == 0 || negativeHalf == 0)
                    continue;
                res[i] = half;
                res[n - 1 - i] = negativeHalf;
                half++;
                negativeHalf--;
            }
        }
        return res;
    }
}