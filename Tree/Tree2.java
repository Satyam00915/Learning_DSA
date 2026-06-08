import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree2 {

    public static class Node {
        int data;
        Node right;
        Node left;

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

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static int product(Node root) {
        if (root == null) {
            return 1;
        }

        return product(root.left) * product(root.right) * root.data;
    }

    static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);

        System.out.print(root.data + " ");
    }

    static List<List<Integer>> levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            

            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);


                level.add(temp.data);

            }

            ans.add(level);

        }
        return ans;

    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(4);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(5);

        root.right.right = new Node(8);
        root.right.right.left = new Node(9);

        // System.out.println(height(root));
        // System.out.println(product(root));

        // preorder(root);

        // postorder(root);

        

        

    }
}
