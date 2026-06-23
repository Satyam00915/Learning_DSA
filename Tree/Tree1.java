public class Tree1 {

    public static class Node {
        int data;
        Node right;
        Node left;

        Node(int data , Node right , Node left) {
            this.data = data;
            this.right = right;
            this.left = left;
        }

        Node(int data) {
            this.data = data;
            // this.right = null;
            // this.left = null;
        }
    }

    public static void display(Node root) {
        System.out.print(root.data + " -> ");
        System.out.print(root.left.data +" ,");
        System.out.println(root.right.data);

        display(root.left);
        display(root.right);
    }

    public static int size(Node root) {
        if(root == null) return 0;

        return 1 + size(root.left) + size(root.right);
    }

    public static int sum(Node root) {
        if(root == null) return 0;

        return root.data + sum(root.left) + sum(root.right);
    }

    public static int maxNode(Node root){
        if(root == null) return 0;

        int lst = maxNode(root.left);
        int rst = maxNode(root.right);

        return Math.max(root.data, Math.max(lst, rst));
    }

    public static void main(String[] args) {
       Node root = new Node(2);

        root.left = new Node(4);
        root.right = new Node(10);

        root.left.left = new Node(6);
        root.left.right = new Node(15);

        root.right.right = new Node(11);

        System.out.println(maxNode(root));


    }
}



