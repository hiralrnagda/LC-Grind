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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        boolean even = true;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> sublist = new LinkedList();
            for(int i = 0; i < size; i++)
            {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                sublist.add(q.poll().val);
            }
            even = !even;
            res.add(sublist);
        }
        return res;
    }
}