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
    // BFS - maintain 3 pointers - max, level and res - update res and max based on
    // the sum of nodes at a particular level,
    public int maxLevelSum(TreeNode root) {
        int level = 0, res = 0;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }

            if (max < sum) {
                max = sum;
                res = level;
            }

        }
        return res;
    }
}