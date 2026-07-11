import java.util.ArrayList;

public class Practice2 {

    // DFS ADJACENT MATRIX
    public static void DFS(int[][] grid, boolean[] visited, int n) {
        visited[n] = true;
        System.out.print(n + " ");

        for (int i = 0; i < grid.length; i++) {
            if (!visited[i] && grid[n][i] == 1) {
                DFS(grid, visited, i);
            }
        }

    }

    // DFS ADJACENT LIST
    public static void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int n) {
        visited[n] = true;
        System.out.print(n + " ");

        for (int idx : adj.get(n)) {
            if (!visited[idx]) {
                DFS(adj, visited, idx);
            }
        }
    }

    public static void main(String[] args) {
        // int[][] grid = {
        // { 1, 1, 1, 1, 0 },
        // { 1, 1, 0, 0, 0 },
        // { 1, 0, 1, 0, 1 },
        // { 1, 0, 0, 1, 0 },
        // { 0, 0, 1, 0, 1 }
        // };

        // boolean[] visited = new boolean[grid.length];

        // DFS(grid, visited, 0);

        int V = 8;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(0);
        adj.get(2).add(5);

        adj.get(3).add(1);

        adj.get(4).add(1);
        adj.get(4).add(5);
        adj.get(4).add(6);

        adj.get(5).add(2);
        adj.get(5).add(4);
        adj.get(5).add(7);

        adj.get(6).add(4);
        adj.get(6).add(7);

        adj.get(7).add(5);
        adj.get(7).add(6);

        boolean[] visited = new boolean[adj.size()];

        DFS(adj, visited, 0);

    }
}
