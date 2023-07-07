/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // Recursive approach
    // TC: O(n) SC: O(n)
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // if(root == null) return null;
    // int current = root.val;
    // if(current > p.val && current > q.val)
    // {
    // return lowestCommonAncestor(root.left, p, q);
    // }
    // if(current < p.val && current < q.val)
    // {
    // return lowestCommonAncestor(root.right, p, q);
    // }
    // return root;
    // }

    // iterative approach
    // TC: O(n) SC:O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        int pVal = p.val, qVal = q.val;
        TreeNode curr = root;
        while (curr != null) {
            int currVal = curr.val;
            if (currVal > pVal && currVal > qVal) {
                curr = curr.left;
            } else if (currVal < pVal && currVal < qVal) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }
}