class Solution {
    private void findAllSubsets(int ind, int n, int []nums,     List<List<Integer>> res, List<Integer> ds)
    {   
        //base condition
        if(ind == n)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        //not pick
        findAllSubsets(ind + 1, n, nums, res, ds);
        
        //pick - trial room example
        ds.add(nums[ind]);
        findAllSubsets(ind + 1, n, nums, res, ds);
        ds.remove(ds.size() - 1);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        findAllSubsets(0, nums.length, nums, res, new ArrayList());
        return res;
    }
}