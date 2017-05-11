package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by neagrawa on 5/1/17.
 * https://leetcode.com/contest/leetcode-weekly-contest-30/problems/reshape-the-matrix/
 */
public class ReshapeTheMatrix extends TestCase {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int originalR = nums.length;
        int originalC = nums[0].length;

        if(originalC*originalR != r*c)
        {
            printMatrix(nums);
            return nums;
        }

        int[][] reshapedMatrix = new int[r][c];
        int rowIndex=0;
        int colIndex=0;

        for (int i = 0; i < originalR; i++) {
            for (int j = 0; j < originalC; j++) {
                reshapedMatrix[rowIndex][colIndex++] = nums[i][j];
                if(colIndex == c){
                    rowIndex++;
                    colIndex = 0;
                }
            }
        }
        printMatrix(reshapedMatrix);
        return reshapedMatrix;
    }

    public void printMatrix(int[][] nums)
    {
        int r = nums.length;

        System.out.print("[");
        for (int i = 0; i < r; i++) {
            System.out.print(Arrays.toString(nums[i]));
            if(i!=r-1) System.out.print(",\n");
        }
        System.out.print("]");
        System.out.println();
    }

    @Test
    public void testMatrixReshape()
    {
        int[][] nums = {{1,2},{3,4}};
        matrixReshape(nums,1,4);
        matrixReshape(nums,2,4);
    }
}
