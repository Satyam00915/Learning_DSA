import java.util.*;

public class Tree8 {
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


    //Right View similar to this just add elements right->left
    public static List<Integer> leftView(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);

                if (i == 0)
                    list.add(temp.data);
            }
        }

        return list;

    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.left.left = new Node(10);

        root.right.right.left = new Node(9);

        List<Integer> list = leftView(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
