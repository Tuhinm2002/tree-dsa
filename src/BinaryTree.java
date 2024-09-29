import java.util.Scanner;

public class BinaryTree {

    private static class Node{
        private Node left;
        private Node right;
        private int val;

        public Node(int val){
            this.val = val;
        }
    }

    private Node root;
    public void populate(Scanner sc){
        if(root == null){
            System.out.println("Start entering values");
        }
        System.out.println(sc);
        int value = sc.nextInt();;
        root = new Node(value);
        populateTree(sc,root);
    }
    private void populateTree(Scanner sc,Node node){
        System.out.println("Do you want to add left of " + node.val);
        boolean leftBool = sc.nextBoolean();
        if(leftBool){
            System.out.println("Enter the value of left node : ");
            int leftValue = sc.nextInt();
            node.left = new Node(leftValue);
            populateTree(sc,node.left);
        }

        System.out.println("Do you want to add right of "+node.val);
        boolean rightBool = sc.nextBoolean();
        if(rightBool){
            System.out.println("Enter the value of right node : ");
            int rightValue = sc.nextInt();
            node.right = new Node(rightValue);
            populateTree(sc,node.right);
        }
    }

    public void display(){
        displayTree(root,"");
    }

    private void displayTree(Node node,String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.val);
        displayTree(node.left,indent + " ");
        displayTree(node.right,indent + " ");
    }

    public void preetyDisplay(){
        preetyDisplayTree(root,0);
    }

    private void preetyDisplayTree(Node node,int level){
        if(node == null){
            return;
        }
        preetyDisplayTree(node.right,level+1);
        if(level != 0){
            for (int i = 0; i < level - 1; i++) {
                System.out.println("|\t\t");
            }
            System.out.println("---------->"+node.val);
        }
        else { // This line is for root
            System.out.println(node.val);
        }
        preetyDisplayTree(node.left,level+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree btree = new BinaryTree();
        btree.populate(sc);
//        btree.display();
        btree.preetyDisplay();
    }
}
