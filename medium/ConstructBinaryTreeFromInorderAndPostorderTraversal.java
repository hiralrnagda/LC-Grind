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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode solve(int []inorder, int inStart, int inEnd, int []postorder, int posStart, int posEnd){
        if(posStart > posEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[posEnd]);
        int inRoot = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                break;
            }
            inRoot++;
        }

        root.left = solve(inorder, inStart, inRoot - 1, postorder, posStart, posStart + inRoot - inStart - 1);
        root.right = solve(inorder, inRoot + 1, inEnd, postorder, posStart + inRoot - inStart, posEnd - 1);

        return root;
    }
}