import java.util.Arrays;

public class Graph5 {
    public static void printMatrix(char[][] mat) {
        for (char[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static void dfs(char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O'
                    && !visited[nr][nc]) {
                dfs(board, nr, nc, visited);
            }
        }
    }

    public static void SurroundedRegions(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(board, 0, j, visited);
            }
            if (board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                dfs(board, m - 1, j, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, i, 0, visited);
            }
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                dfs(board, i, n - 1, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };

        SurroundedRegions(board);

        printMatrix(board);

    }
}
