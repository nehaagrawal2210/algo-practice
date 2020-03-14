package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import junit.framework.TestCase;

//https://www.geeksforgeeks.org/minimum-initial-vertices-traverse-whole-matrix-given-conditions/
public class MatrixTraversal extends TestCase {

    class Cell implements Comparable<Cell> {
        int row, col, value;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Cell o) {
            if (value == o.value) {
                return row - o.row;
            }
            return value - o.value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Cell{");
            sb.append(row);
            sb.append(", ").append(col);
            sb.append(", val=").append(value);
            sb.append('}');
            return sb.toString();
        }
    }

    private List<Cell> createAndSortCells(int[][] matrix) {
        List<Cell> cellList = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                cellList.add(new Cell(row, col, matrix[row][col]));
            }
        }
        Collections.sort(cellList, Comparator.reverseOrder());
        return cellList;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int r, int c) {
        int M = matrix.length;
        int N = matrix[0].length;
        visited[r][c] = true;
        if (r + 1 < M && matrix[r + 1][c] <= matrix[r][c] && !visited[r + 1][c]) {
            dfs(matrix, visited, r + 1, c);
        }
        if (c + 1 < N && matrix[r][c + 1] <= matrix[r][c] && !visited[r][c + 1]) {
            dfs(matrix, visited, r, c + 1);
        }
        if (r - 1 >= 0 && matrix[r - 1][c] <= matrix[r][c] && !visited[r - 1][c]) {
            dfs(matrix, visited, r - 1, c);
        }
        if (c - 1 >= 0 && matrix[r][c - 1] <= matrix[r][c] && !visited[r][c - 1]) {
            dfs(matrix, visited, r, c - 1);
        }
    }

    public List<Cell> verticesToTraverseMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        List<Cell> cellList = createAndSortCells(matrix);
        boolean[][] visited = new boolean[r][c];

        // mark all nodes as non visited
        for (boolean[] visit : visited) {
            Arrays.fill(visit, false);
        }

        List<Cell> res = new ArrayList<>();
        for (Cell cell : cellList) {
            if (!visited[cell.row][cell.col]) {
                res.add(cell);
                dfs(matrix, visited, cell.row, cell.col);
            }
        }
        return res;
    }

    public void testMinVerticesToTraverseMat() {
        int adj[][] = { { 3, 3 }, { 1, 1 } };
        List<Cell> res = verticesToTraverseMatrix(adj);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public void testMinVertices() {
        int adj[][] = { { 1, 2, 3 }, { 2, 3, 1 }, { 1, 1, 1 } };
        List<Cell> res = verticesToTraverseMatrix(adj);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
