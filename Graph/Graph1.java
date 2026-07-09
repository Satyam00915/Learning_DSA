import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {

    public static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];

        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int num = q.poll();
            ans.add(num);

            for (int idx : adj.get(num)) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    q.offer(idx);
                }
            }
        }

        return ans;
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, int n, boolean[] visited) {

        ans.add(n);
        visited[n] = true;

        for (int idx : adj.get(n)) {
            if (!visited[idx]) {
                DFS(adj, ans, idx, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected Graph
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(0).add(3);
        adj.get(3).add(0);

        adj.get(1).add(4);
        adj.get(4).add(1);

        adj.get(1).add(5);
        adj.get(5).add(1);

        adj.get(2).add(5);
        adj.get(5).add(2);

        adj.get(3).add(6);
        adj.get(6).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);

        // ArrayList<Integer> bfs = BFS(adj);
        // for (int n : bfs) {
        // System.out.print(n + " ");
        // }

        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> dfs = new ArrayList<>();
        DFS(adj, dfs, 0, visited);
        for (int n : dfs) {
            System.out.print(n + " ");
        }
    }
}