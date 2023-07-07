class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        int n = candies.length;
        List<Boolean> res = new ArrayList();
        for (int i = 0; i < n; i++) {
            max = Math.max(max, candies[i]);
        }

        for (int i = 0; i < n; i++) {
            int x = extraCandies + candies[i];
            res.add(x >= max);
        }
        return res;
    }
}