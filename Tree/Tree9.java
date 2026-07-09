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

    // Method 1:
    // public static int leftM;
    // public static int rightM;

    // public static void Find(Node root, int pos) {
    // if (root == null)
    // return;

    // leftM = Math.min(leftM, pos);
    // rightM = Math.max(rightM, pos);

    // Find(root.left, pos - 1);
    // Find(root.right, pos + 1);

    // }

    // public static void topView(Node root, int[] arr, int pos) {
    // Queue<Pair> q = new LinkedList<>();
    // q.offer(new Pair(root, pos));

    // while (!q.isEmpty()) {
    // Pair p = q.poll();
    // Node temp = p.node;
    // int idx = p.idx;

    // if (temp.left != null)
    // q.offer(new Pair(temp.left, idx - 1));
    // if (temp.right != null)
    // q.offer(new Pair(temp.right, idx + 1));

    // if (arr[idx] == 0) {
    // arr[idx] = temp.data;
    // }
    // }
    // }

    public static List<Integer> topView(Node root) {
        List<Integer> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.node.left != null)
                q.offer(new Pair(p.node.left, p.idx - 1));

            if (p.node.right != null)
                q.offer(new Pair(p.node.right, p.idx + 1));

            if (!map.containsKey(p.idx)) {
                map.put(p.idx, p.node.data);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
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

        root.left.left.left = new Node(8);
        root.right.right.right = new Node(9);

        // leftM = 0;
        // rightM = 0;
        // Find(root, 0);

        // int size = rightM - leftM + 1;
        // int[] topViewArr = new int[size];

        // topView(root, topViewArr, Math.abs(leftM));

        // for (int i = 0; i < size; i++) {
        // System.out.print(topViewArr[i] + " ");
        // }

        List<Integer> ans = topView(root);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }

}
