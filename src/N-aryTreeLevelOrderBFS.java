/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        while(root == null){
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<n;i++){
                Node tmpNode = queue.poll();
                temp.add(tmpNode.val);

            if(tmpNode.children != null){
                for (Node nodeIter : tmpNode.children){
                    queue.offer(nodeIter);
                }
            }
        }
            
        res.add(temp);
        }

        return res;
    }
}
