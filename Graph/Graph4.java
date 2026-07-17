import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph4 {

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static int[][] closestZero(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int[][] newMat = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    newMat[i][j] = 0;
                    q.offer(new Pair(i, j));
                } else {
                    newMat[i][j] = -1;
                }
            }
        }

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = p.i + dr[k];
                int nc = p.j + dc[k];

                if (nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && newMat[nr][nc] == -1) {
                    newMat[nr][nc] = newMat[p.i][p.j] + 1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        return newMat;
    }

    public static void main(String[] args) {

        int[][] mat1 = {
                { 1, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 1, 1 }
        };

        int[][] ans = closestZero(mat1);

        printMatrix(ans);

    }
}
