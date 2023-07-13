class Solution {
    private void solve(int n, int k, int start, List<List<Integer>> res, List<Integer> ds)
    {
        if(ds.size() == k)
        {
            res.add(new ArrayList(ds));
            return;
        }
        for(int i = start; i <= n; i++) 
        {
            ds.add(i);
            solve(n, k, i + 1, res, ds);
            ds.remove(ds.size() - 1);
        }       
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solve(n, k, 1, res, new ArrayList());
        return res;
    }
}