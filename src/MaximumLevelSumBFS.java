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
    public int maxLevelSum(TreeNode root) {
        

        if(root == null){
            return 1;
        }
        
        
        Map<Integer,Integer> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int t = 1;

        while(!queue.isEmpty()){

            int level = queue.size();
            int levelSum = 0;
            for (int i=0;i<level;i++){
                TreeNode tmpNode = queue.poll();
                levelSum += tmpNode.val;

            if(tmpNode.left != null){
                queue.offer(tmpNode.left);
            }

            if(tmpNode.right != null){
                queue.offer(tmpNode.right);
            }
            
            }
            map.put(t,levelSum);
            t += 1;
        }

        int currentVal = Integer.MIN_VALUE;
        int maxIndex = 1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > currentVal){
                currentVal = entry.getValue() ;
                maxIndex = entry.getKey();
            }
        }

        return maxIndex;
    }
}
