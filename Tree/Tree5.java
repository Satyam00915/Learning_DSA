import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Tree5 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

    public static int MaximumDepthOfBT(Node root) {
        if (root == null)
            return 0;

        return Math.max(MaximumDepthOfBT(root.left), MaximumDepthOfBT(root.right)) + 1;
    }

    public static List<List<Integer>> zigzagTraversal(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q1 = new LinkedList<>();

        q1.offer(root);
        boolean ltr = true;

        while (!q1.isEmpty()) {
            int size = q1.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node temp = q1.poll();
                if (temp.left != null)
                    q1.add(temp.left);
                if (temp.right != null)
                    q1.add(temp.right);

                if (ltr) {
                    level.addLast(temp.data);
                } else {
                    level.addFirst(temp.data);
                }

            }
            ltr = !ltr;
            list.add(level);
        }

        return list;

    }

    public static void main(String[] args) {
        // Node root = new Node(1);
        // // root.left = new Node(2);

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

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(MaximumDepthOfBT(root));

        List<List<Integer>> list = zigzagTraversal(root);
        int m = list.size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
