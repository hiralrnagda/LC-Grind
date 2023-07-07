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
    static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    void addLeftBoundary(TreeNode node, List<Integer> ans) {
        TreeNode curr = node.left;
        while (curr != null) {
            if (isLeaf(curr) == false)
                ans.add(curr.val);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    void addLeafNodes(TreeNode node, List<Integer> ans) {
        if (isLeaf(node)) {
            ans.add(node.val);
            return;
        }

        if (node.left != null)
            addLeafNodes(node.left, ans);
        if (node.right != null)
            addLeafNodes(node.right, ans);
    }

    void addRightBoundary(TreeNode node, List<Integer> ans) {
        TreeNode curr = node.right;
        List<Integer> tmp = new ArrayList();
        while (curr != null) {
            if (isLeaf(curr) == false)
                tmp.add(curr.val);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        // reverse the right boundary and add to ans list
        for (int i = tmp.size() - 1; i >= 0; i--) {
            ans.add(tmp.get(i));
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        /**
         * Anticlockwise cycle
         * 1. left boundary excluding leaf nodes
         * 2. leaf nodes
         * 3. right boundary excluding leaf nodes in reverse order
         */
        List<Integer> ans = new ArrayList();
        if (isLeaf(root) == false)
            ans.add(root.val);
        addLeftBoundary(root, ans);
        addLeafNodes(root, ans);
        addRightBoundary(root, ans);

        return ans;
    }
}