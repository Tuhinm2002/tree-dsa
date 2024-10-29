/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
               Node rightNode = null;
            //    int n = ;
               for(int i = queue.size(); i > 0; i--){

                Node curr = queue.poll();
                curr.next = rightNode;
                rightNode = curr;

                if(curr.right != null){
                    queue.offer(curr.right);
               }

               if(curr.left != null){
                queue.offer(curr.left);
               }
         }

        }

        return root;
    }
}
