public class Tree6 {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }

    static int BalanceBinaryTree(Node root) {
        if (root == null)
            return 0;

        int lst = BalanceBinaryTree(root.left);
        int rst = BalanceBinaryTree(root.right);

        if (lst == -1 || rst == -1) {
            return -1;
        }

        if (Math.abs(lst - rst) > 1) {
            return -1;
        } else {
            return Math.max(lst, rst) + 1;
        }
    }

    

    public static void main(String[] args) {
        Node balancedTree = new Node(
                1,
                new Node(
                        2,
                        new Node(4),
                        new Node(5)),
                new Node(
                        3,
                        new Node(6),
                        new Node(7)));

        Node unbalancedTree = new Node(
                1,
                new Node(
                        2,
                        new Node(
                                3,
                                new Node(4),
                                null),
                        null),
                new Node(5));

        System.out.println(BalanceBinaryTree(unbalancedTree) != -1);
    }

}
