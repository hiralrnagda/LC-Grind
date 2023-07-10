package easy;

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
    private void solve(TreeNode root, List<String> res, String ds) {
        if (root != null) {
            ds += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                res.add(ds);
            } else {
                ds += "->";
                solve(root.left, res, ds);
                solve(root.right, res, ds);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList();
        solve(root, res, "");
        return res;
    }
}