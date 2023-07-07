class Solution {
    public int subarraySum(int[] nums, int k) {
        /**
         * Here we are using hashing - and also using hashmap
         * we are calculating prefixSum and as it is about subarray
         */
        Map<Integer, Integer> count = new HashMap();
        count.put(0, 1);
        int answer = 0;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            answer += count.getOrDefault(prefixSum - k, 0);
            count.put(prefixSum, count.getOrDefault(prefixSum, 0) + 1);
        }
        return answer;
    }
    /*
     * brute force - generate all the subarrays compute the sum check if equal to k
     * and update the answer - O(n3)
     * 
     * better approach - we are using 2 pointers start and end
     * have 2 variables total and ans - total to keep track of if sum ==k and update
     * ans accordingly -
     * TC - O(n2)
     * SC - O(1)
     */
    // public int subarraySum(int[] nums, int k) {
    // int ans = 0;
    // for(int start = 0; start < nums.length; start++)
    // {
    // int total = 0;
    // for(int end = start; end < nums.length; end++)
    // {
    // total += nums[end];
    // if(total == k)
    // {
    // ans++;
    // }
    // }
    // }
    // return ans;
    // }
}