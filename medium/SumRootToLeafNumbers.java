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
    public int sumNumbers(TreeNode root) {
        // Approach: DFS preorder traversal
        int rootToLeaf = 0;
        int current = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            current = p.getValue();

            if (root != null) {
                current = current * 10 + root.val;
                // if leaf is a root node
                if (root.left == null && root.right == null) {
                    rootToLeaf += current;
                } else {
                    stack.push(new Pair(root.right, current));
                    stack.push(new Pair(root.left, current));
                }
            }
        }
        return rootToLeaf;
    }
}