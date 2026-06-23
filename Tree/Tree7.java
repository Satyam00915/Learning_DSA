
public class Tree7 {
    public static class Node {
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

    public static int maxm;

    public static int maxPathSum(Node root) {
        if (root == null)
            return 0;

        int lst = Math.max(0, maxPathSum(root.left));
        int rst = Math.max(0, maxPathSum(root.right));

        int total = lst + rst + root.data;
        maxm = Math.max(maxm, total);

        return Math.max(lst, rst) + root.data;

    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        maxm = 0;
        maxPathSum(root);
        System.out.println(maxm);
    }
}
