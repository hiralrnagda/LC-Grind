/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode helper(int nums[], int left, int right)
    {
        if(left > right) return null;

        int pivot = (left + right) / 2;

        TreeNode root = new TreeNode(nums[pivot]);

        root.left = helper(nums, left, pivot - 1);
        root.right = helper(nums, pivot + 1, right);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
}