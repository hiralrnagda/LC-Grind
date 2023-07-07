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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            stack.pop();
            if (current != null) {
                result.add(current.val);
                stack.add(current.right);
                stack.add(current.left);
            }
        }
        return result;
    }
}