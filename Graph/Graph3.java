import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph3 {

    static class Pair {
        int i;
        int j;
        int lvl;

        Pair(int i, int j, int lvl) {
            this.i = i;
            this.j = j;
            this.lvl = lvl;
        }
    }

    public static int RottenOranges(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int lvl = 0;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.i + dr[i];
                int nc = p.j + dc[i];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    q.offer(new Pair(nr, nc, p.lvl + 1));
                    fresh--;
                    lvl = p.lvl + 1;
                }
            }
        }

        return fresh == 0 ? lvl : -1;
    }

    public static boolean DetectACycle(List<List<Integer>> adj, int n, int parent, boolean[] visited) {
        visited[n] = true;

        for (int idx : adj.get(n)) {
            if (!visited[idx]) {
                if (DetectACycle(adj, idx, n, visited)) {
                    return true;
                }
            } else if (idx != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // int[][] grid = {
        // { 2, 1, 1 },
        // { 1, 1, 0 },
        // { 0, 1, 1 }
        // };

        // System.out.println(RottenOranges(grid));

        int V = 5;

        int[][] edges = {
                { 0, 1 },
                { 2, 3 },
                { 3, 4 }
        };

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[V];

        boolean flag = false;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (DetectACycle(adj, i, -1, visited)) {
                    flag = true;
                }
            }
        }
        System.out.println(flag);

    }
}
