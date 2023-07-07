class Solution {
    public int[] searchRange(int[] nums, int target) {

        int firstOccurrence = findBound(nums, target, true);
        
        if (firstOccurrence == -1) {
            return new int[]{-1, -1};
        }
        
        int lastOccurrence = findBound(nums, target, false);
        
        return new int[]{firstOccurrence, lastOccurrence};

    }

    private int findBound(int []nums, int target, boolean isFirst){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target)
            {
                if(isFirst)
                {
                    if(mid == low || nums[mid - 1] != target)
                    {
                        return mid;
                    }
                   high = mid - 1;
                } 
                else {
                    if(mid == high || nums[mid + 1] != target)
                    {
                        return mid;
                    }
                    low = mid + 1;
                } 
            }
            else if(target > nums[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}