/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    private boolean helper(TreeNode node) {
        if (node == null)
            return true;

        boolean left = helper(node.left);
        boolean right = helper(node.right);

        if (left && right) {
            if ((node.left != null && node.left.val != node.val) ||
                    (node.right != null && node.right.val != node.val)) {
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
}