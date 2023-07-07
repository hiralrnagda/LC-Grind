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
    public int countNodes(TreeNode root) {
        /**
         * approach 1: we can use any traversal - use a counter to track nodes -
         * approach 2: we can use the property h = log N ->
         * check for leftHeight and rightHeight
         * if unequal =>
         * 
         * if equal => 1 + countNodes(root.left) + countNodes(root.right)
         */
        if (root == null)
            return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }
}