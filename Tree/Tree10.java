import java.util.*;

public class Tree10 {
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

    static class Tuple {
        Node node;
        int vr;
        int lvl;

        Tuple(Node node, int vr, int lvl) {
            this.node = node;
            this.vr = vr;
            this.lvl = lvl;
        }
    }

    public static List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            if (t.node.left != null)
                q.offer(new Tuple(t.node.left, t.vr - 1, t.lvl + 1));
            if (t.node.right != null)
                q.offer(new Tuple(t.node.right, t.vr + 1, t.lvl + 1));
            if (!map.containsKey(t.vr)) {
                map.put(t.vr, new TreeMap<>());
            }

            if (!map.get(t.vr).containsKey(t.lvl)) {
                map.get(t.vr).put(t.lvl, new PriorityQueue<>());
            }

            map.get(t.vr).get(t.lvl).offer(t.node.data);
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> level : map.values()) {
            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : level.values()) {

                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(10);

        root.right.left = new Node(9);
        root.right.right = new Node(10);

        root.left.left.left = new Node(5);

        root.left.left.left.right = new Node(6);

        List<List<Integer>> ans = verticalOrder(root);

        for(int i=0; i<ans.size(); i++) {
            for(int j=0; j<ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
