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
    int Depth = 0;
    public int maxDepth(TreeNode root) {
        return postorder(root);
    }

    public int postorder(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftHeight = postorder(root.left);
        int rightHeight = postorder(root.right);

        Depth = 1 + Math.max(leftHeight , rightHeight);

        return Depth;
    }
}
