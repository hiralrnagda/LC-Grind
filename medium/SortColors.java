class Solution {
    // Approach 1 - using frequency sort
    // public void sortColors(int[] nums) {
    //     int redCount = 0;
    //     int blueCount = 0;
    //     int whiteCount = 0;
    //     for(int i = 0; i < nums.length; i++)
    //     {
    //         if(nums[i] == 0){
    //             redCount++;
    //         }else if(nums[i] == 1){
    //             whiteCount++;
    //         }else{
    //             blueCount++;
    //         }
    //     }
    //     int i = 0;
    //     while(redCount > 0){
    //         nums[i++] = 0; 
    //         redCount--;
    //     }
    //     while(whiteCount > 0){
    //         nums[i++] = 1; 
    //         whiteCount--;
    //     }
    //     while(blueCount > 0){
    //         nums[i++] = 2;
    //         blueCount--; 
    //     }
    // }

    //Approach 2: 3 ptrs - low, mid at start and high at end
    //3 simple rules to follow while mid <= high
    //1. for case 0 - swap(nums[low], nums[mid]) low++, mid++ break
    //2. for case 1 - mid++ break
    //3. for case 2 - swap(nums[mid], nums[high]) high-- break
    public void sortColors(int[] nums){
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        int temp;
        while(mid <= high)
        {
            switch(nums[mid]){
                case 0: {
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;
                }
            }
        }
        return;
    }
}