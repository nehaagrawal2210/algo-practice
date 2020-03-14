package practice;

public class ImageRotation {
    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int topLevel = layer;
            int bottomLevel = n - layer - 1;

            for (int i = topLevel; i < bottomLevel; i++) {
                int adjustment = i - topLevel;
                int tempTop = matrix[topLevel][i];
                matrix[topLevel][i] = matrix[bottomLevel - adjustment][topLevel];
                matrix[bottomLevel - adjustment][topLevel] = matrix[bottomLevel][bottomLevel - adjustment];
                matrix[bottomLevel][bottomLevel - adjustment] = matrix[i][bottomLevel];
                matrix[i][bottomLevel] = tempTop;
            }
        }
        return true;
    }

    public static void printMatrix(int[][] a) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                System.out.print(a[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        rotate(a);
        printMatrix(a);
    }
}
