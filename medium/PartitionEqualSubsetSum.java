class Solution {
    public boolean canPartition(int[] nums) {
        //subset sum - AV 
        /*
        sum of the entire array must be even - only then we can look for 2 subsets having equal sum
        */ 
        int sum = 0;
        for(int n: nums) sum += n;
        
        if(sum % 2 != 0){//odd sum - can't be divided in 2 equal halves
            return false;
        } 
        /**
        now here we only need to find one subset with sum = sum/2 other one is already existing => boiling it down to subset sum problem
        */

        int n = nums.length;
        sum /= 2;

        boolean dp[][] = new boolean[n + 1][sum + 1];

        for(int i = 0; i <= n; i++) dp[i][0] = true; //1st row intialize with true
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++)
            {
                if(nums[i - 1] <= j){ //curr element is <= sum only then we have a choice of including or excluding that element
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - nums[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];   
    }
}