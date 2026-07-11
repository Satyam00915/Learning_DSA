import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice {

    // Adjacency Matrix BFS
    public static void BFS(int[][] grid) {
        boolean[] visited = new boolean[grid.length];
        Queue<Integer> q = new LinkedList<>();

        visited[2] = true;
        q.offer(2);

        while (!q.isEmpty()) {
            int num = q.poll();
            System.out.print(num + " ");

            for (int i = 0; i < grid[0].length; i++) {
                if (!visited[i] && grid[num][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    // Adjacency List BFS
    public static void BFS(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        visited[7] = true;
        q.offer(7);

        while (!q.isEmpty()) {
            int num = q.poll();
            System.out.print(num + " ");

            for (int idx : adj.get(num)) {
                if (!visited[idx]) {
                    q.offer(idx);
                    visited[idx] = true;
                }
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

        BFS(adj);

        // BFS(grid);

    }
}
