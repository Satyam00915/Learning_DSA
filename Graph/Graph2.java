import java.util.ArrayList;

public class Graph2 {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int n, boolean[] visit) {
        visit[n] = true;

        for (int idx : adj.get(n)) {
            if (!visit[idx]) {
                dfs(adj, idx, visit);
            }
        }
    }

    public static int numberOfProvince(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        int cnt = 0;

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Component 1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // Component 2
        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(2).add(4);
        adj.get(4).add(2);

        // Component 3
        adj.get(5).add(6);
        adj.get(6).add(5);

        // Number of Provinces
        System.out.println(numberOfProvince(adj));

    }

}
