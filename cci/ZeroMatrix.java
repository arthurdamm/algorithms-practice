/* Cracking the Code Interview 1.8 ZeroMatrix
 * If element of MxN matrix is 0, its entire row and col are set to 0
 * 
 */

import java.util.Arrays;

public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] m0 = {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 0, 18},
            {19, 20, 0, 22, 23, 24},
            {25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36},
        };
        printMatrix(m0);
        print("\n");
        printMatrix(zeroMatrix(m0));
        print("\n");
        int[][] m1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 0},
        };
        printMatrix(m1);
        print("\n");
        printMatrix(zeroMatrix(m1));
        print("\n");
        int[][] m2 = {
            {0, 2, 3, 4},
            {5, 0, 7, 8},
            {9, 10, 0, 12},
            {13, 14, 15, 0},
        };
        printMatrix(m2);
        print("\n");
        printMatrix(zeroMatrix(m2));
        print("\n");
        int[][] m3 = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9},
        };
        printMatrix(m3);
        print("\n");
        printMatrix(zeroMatrix(m3));
        print("\n");
        int[][] m4 = {
            {1, 2},
            {0, 4}
        };
        printMatrix(m4);
        print("\n");
        printMatrix(zeroMatrix(m4));
        print("\n");
        int[][] m5 = {
            {0},
        };
        printMatrix(m5);
        print("\n");
        printMatrix(zeroMatrix(m5));

    }

    public static void printMatrix(int[][] arg) {
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                print(String.format("%2d", arg[i][j]) + ", ");
            }
            print("\n");
        }
    }

    public static void print(Object arg) {
        System.out.print(arg); 
    }

    public static int[][] zeroMatrix(int[][] m) {
        // set up two data arrays to track which rows/cols need to be zeroed
        int[] rows = new int[m.length];
        int[] cols = new int[m[0].length];
        // traverse all cells and toggle rows/cols to be zeroed
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        // fill all the rows
        for (int i = 0; i < rows.length; i++)
            if (rows[i] != 0)
                Arrays.fill(m[i], 0);

        // fill all the cols whose rows are unfilled
        for (int i = 0; i < m.length; i++) {
            if (rows[i] == 0) {
                for (int j = 0; j < m[i].length; j++)
                    if (cols[j] != 0)
                        m[i][j] = 0;
            }
        }
                
        return m;
    }

}
