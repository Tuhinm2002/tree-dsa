public class SegmentTrees {

    private static class Node{
        private int startIndex;
        private int endIndex;
        private Node left;
        private Node right;
        private int data;

        public Node(int startIndex,int endIndex){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    private Node root;

    public Node insert(int[] arr,int start,int end){
        if(start == end){
            Node node = new Node(start,end);
            node.data = arr[start];
            return node;
        }

        Node newNode = new Node(start,end);
        int mid = (start + end) / 2 ;

        newNode.left = insert(arr,start,mid);
        newNode.right = insert(arr,mid+1,end);

        newNode.data = newNode.left.data + newNode.right.data;

        return newNode;
    }

    public void display(Node node){
        if(node == null){
            System.out.println("Tree ended");
            return;
        }
        System.out.println("Data value : "+node.data);
        System.out.println("Start index : "+node.startIndex+" End index : "+node.endIndex);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,8,6,3,10};
        SegmentTrees segmentTrees = new SegmentTrees();
        Node node = segmentTrees.insert(arr,0,arr.length-1);
        segmentTrees.display(node);
    }
}