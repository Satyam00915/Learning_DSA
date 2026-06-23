import java.util.*;

public class Tree9 {
    public static class Node {
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
            this.right = right;
            this.left = left;
        }

    }

    public static class Pair {
        Node node;
        int idx;

        Pair(Node node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public static int leftM;
    public static int rightM;

    public static void Find(Node root, int pos) {
        if (root == null)
            return;

        leftM = Math.min(leftM, pos);
        rightM = Math.max(rightM, pos);

        Find(root.left, pos - 1);
        Find(root.right, pos + 1);

    }

    public static void topView(Node root, int[] arr, int pos) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, pos));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node temp = p.node;
            int idx = p.idx;

            if (temp.left != null)
                q.offer(new Pair(temp.left, idx - 1));
            if (temp.right != null)
                q.offer(new Pair(temp.right, idx + 1));

            if (arr[idx] == 0) {
                arr[idx] = temp.data;
            }

        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);

        leftM = 0;
        rightM = 0;
        Find(root, 0);

        int size = rightM - leftM + 1;
        System.out.println(size);

        int[] topViewArr = new int[size];

        topView(root, topViewArr, Math.abs(leftM));

        for (int i = 0; i < size; i++) {
            System.out.print(topViewArr[i] + " ");
        }

    }

}
