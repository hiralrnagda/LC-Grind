package hard;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        //array preprocessing
        //prefix sum
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++)
        {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        //suffix sum
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n - 2; i >= 0; i--)
        {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;
        for(int i = 1; i < n - 1 ; i++)//skipping the edge bars
        {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
} 