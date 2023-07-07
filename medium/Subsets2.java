class Solution {
    private void findAllSubsets(int ind, int n, int []nums,     List<List<Integer>> res, List<Integer> ds)
    {   
        //base condition
        res.add(new ArrayList<>(ds));

        for(int i = ind; i < n; i++)
        {
            if(i > ind && nums[i] == nums[i - 1]) continue;
            
            //pick - trial room example
            ds.add(nums[i]);
            findAllSubsets(i + 1, n, nums, res, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        findAllSubsets(0, nums.length, nums, res, new ArrayList());
        return res;
    }
}