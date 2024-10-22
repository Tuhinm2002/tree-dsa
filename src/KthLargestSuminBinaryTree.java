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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        List<Long> ans = bfsTree(root);

        if (k>ans.size()){
            return -1;
        }

        ans.sort(Collections.reverseOrder());

        return ans.get(k-1);
    }

    public List<Long> bfsTree(TreeNode root){

        List<Long> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            long dsum = 0;
            for(int i=0;i<n;i++){
                TreeNode tmpNode = queue.poll();
                dsum += tmpNode.val;

                if(tmpNode.left != null){
                    queue.offer(tmpNode.left);
                }

                if(tmpNode.right != null){
                    queue.offer(tmpNode.right);
                }
            }

            ans.add(dsum);
        }

        return ans;
    }
}
