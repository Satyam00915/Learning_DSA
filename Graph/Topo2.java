import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topo2 {
    // BFS KAHNS ALGORITHM
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(4);

        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(4).add(6);

        adj.get(5).add(6);

        int[] indegree = new int[7];

        for (int i = 1; i <= 6; i++) {
            for (int idx : adj.get(i)) {
                indegree[idx]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 6; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {

            int num = q.poll();
            for (int idx : adj.get(num)) {
                indegree[idx]--;
                if (indegree[idx] == 0) {
                    q.offer(idx);
                }
            }
            list.add(num);
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
