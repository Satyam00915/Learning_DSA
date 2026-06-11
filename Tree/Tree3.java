import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree3 {

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

    static List<Integer> preorder(Node root) {
        Stack<Node> st = new Stack<>();
        List<Integer> preorder = new ArrayList<>();

        st.push(root);
        while (!st.isEmpty()) {
            Node temp = st.pop();
            if (temp.right != null)
                st.push(temp.right);
            if (temp.left != null)
                st.push(temp.left);

            preorder.add(temp.data);
        }

        return preorder;

    }

    static List<Integer> inorder(Node root) {
        Stack<Node> st = new Stack<>();
        List<Integer> inorder = new ArrayList<>();

        Node curr = root;

        while (!st.isEmpty() || curr != null) {

            if (curr == null) {
                Node temp = st.pop();
                inorder.add(temp.data);
                curr = temp.right;
            } else {
                st.push(curr);
                curr = curr.left;
            }

        }

        return inorder;
    }

    

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(4);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(5);

        root.right.right = new Node(8);
        root.right.right.left = new Node(9);

    }
}
