class Solution {
    private void findPermutations(int nums[], int n, boolean f[], List<Integer> ds, List<List<Integer>> ans)
    {
        if(ds.size() == n)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(!f[i])
            {
                f[i] = true;
                ds.add(nums[i]);
                findPermutations(nums, n, f, ds, ans);
                ds.remove(ds.size() - 1);
                f[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        findPermutations(nums, nums.length, new boolean[nums.length], new ArrayList(), ans);
        return ans;
    }
}