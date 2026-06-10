public class Tree4 {

    static int diameter;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node right, Node left) {
            this.data = data;
            this.right = right;
            this.left = left;
        }

    }

    static int diameterOfTree(Node root) {
        if (root == null)
            return 0;

        int lst = diameterOfTree(root.left);
        int rst = diameterOfTree(root.right);

        diameter = Math.max(diameter, lst + rst);

        return Math.max(lst, rst) + 1;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);

        // root.left = new Node(2);
        // root.right = new Node(3);

        // root.right.left = new Node(4);
        // root.right.left.left = new Node(5);
        // root.right.left.left.left = new Node(6);
        // root.right.left.left.left.left = new Node(7);

        // root.right.right = new Node(6);
        // root.right.right.right = new Node(8);
        // root.right.right.right.right = new Node(9);
        // root.right.right.right.right.right = new Node(10);

        diameter = 0;

        diameterOfTree(root);

        System.out.println(diameter);
    }

}
