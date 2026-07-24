import java.util.*;

public class Topo {
    public static void dfs(int n, List<List<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[n] = true;

        for (int idx : adj.get(n)) {
            if (!visited[idx]) {
                dfs(idx, adj, visited, st);
            }
        }

        st.push(n);
    }

    public static void main(String[] args) {
        // Topological Sort

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(5).add(2);

        adj.get(2).add(3);

        adj.get(3).add(1);

        adj.get(4).add(0);
        adj.get(4).add(1);

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[6];
        for (int i = 0; i < 6; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, st);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        for (int n : ans) {
            System.out.print(n + " ");
        }

    }
}
