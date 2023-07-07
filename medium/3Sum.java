class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        HashSet set = new HashSet();

        for(int i = 0; i < nums.length - 2; i++)
        {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1]))
            {
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k)
                {
                    String key = String.valueOf(nums[i]) + "," 
                    + String.valueOf(nums[j]) + "," + String.valueOf(nums[k]);

                    if(!set.contains(key) && nums[i] + nums[j] + nums[k] == 0){
                        List temp = new ArrayList();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        result.add(temp);
                        set.add(key);
                        j++;
                        k--;
                    }
                    else if(nums[i] + nums[j] + nums[k] < 0){
                        j++;
                    }
                    else 
                    {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}