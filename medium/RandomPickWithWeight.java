class Solution {
    private int w_cum[];
    private int sum;

    public Solution(int[] w) {
        sum = 0;
        w_cum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            w_cum[i] = sum;
        }
    }

    public int pickIndex() {
        int idx = (int) (Math.random() * sum);
        return binarySearch(idx + 1);
    }

    private int binarySearch(int val) {
        int l = 0;
        int r = w_cum.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (w_cum[mid] < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */