import java.util.Scanner;

public class BinarySearchTree {
    private static class Node {
        private Node left;
        private Node right;
        private int val;
        private int height;

        public Node(int val) {
            this.val = val;
        }

    }

        private Node root;

        public int getHeight(Node node){
            if(node == null){
                return -1;
            }

            return node.height;
        }

        private Node populateTree(Scanner sc,Node node){
            if (node == null){
                System.out.println("Please enter a value to get started");
                int value = sc.nextInt();
                node = new Node(value);
                return populateTree(sc,node);
            }
            boolean bool = sc.nextBoolean();
            if(bool) {
                int Val = sc.nextInt();
                if (node.val > Val) {
                    Node newNode = new Node(Val);
                    node.left = populateTree(sc, newNode);
                }
                else {
                    Node newNode = new Node(Val);
                    node.right = populateTree(sc, newNode);
                }
            }

            node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
            return node;
        }

        public void display(Node node){
            if(node == null){
                return;
            }
//            System.out.println("root val is : "+rootNode.val);
            System.out.print(node.val + " ");
            display(node.left);
            display(node.right);

        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        Node node = bst.populateTree(sc,bst.root);
        bst.display(node);
        int h = bst.getHeight(node);
        System.out.println(h);
    }

}

