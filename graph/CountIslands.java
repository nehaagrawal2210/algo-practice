package graph;

import java.util.Arrays;

import junit.framework.TestCase;

public class CountIslands extends TestCase {

    public int countIslands(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        for (boolean[] visit : visited) {
            Arrays.fill(visit, false);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    dfs(mat, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValidCell(int[][] mat, boolean[][] visited, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (r < m && r >= 0 && c < n && c >= 0 && mat[r][c] == 1 && !visited[r][c]) {
            return true;
        }
        return false;
    }

    private void dfs(int[][] mat, boolean[][] visited, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[r][c] = true;
        for (int i = 0; i < 8; i++) {
            if (isValidCell(mat, visited, r + rowNbr[i], c + colNbr[i])) {
                dfs(mat, visited, r + rowNbr[i], c + colNbr[i]);
            }
        }
    }

    public void testIslands() {
        int M[][] = { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println(countIslands(M));
    }
}
