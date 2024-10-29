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
    
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        preorder(root);
        return ans;
    }

    public void preorder(TreeNode root){

        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode rightNode = null;
            int n = queue.size();

            for(int i = 0; i < n; i++){
                TreeNode tmpNode = queue.poll();
                if(i == 0)
                ans.add(tmpNode.val);

                if(tmpNode.right != null){
                    queue.offer(tmpNode.right);
                }
                if(tmpNode.left != null){
                    queue.offer(tmpNode.left);
                }
            }
        }
    }
}
