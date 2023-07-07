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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        boolean even = true;
        while(!q.isEmpty())
        {
            int size = q.size();
            LinkedList<Integer> subList = new LinkedList();
            
            for(int i = 0; i < size; i++)
            {
                TreeNode top = q.poll();
                if(top.left != null)
                {
                    q.offer(top.left);
                }
                
                if(top.right != null)
                {
                    q.offer(top.right);
                }
                
                if(even){
                    subList.add(top.val);
                } else {
                    subList.addFirst(top.val);
                }
            }
            res.add(subList);
            even = !even;
        }
        return res;
    }
}