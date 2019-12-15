/* Cracking the Code Interview 1.7 RotateMatrix
 * Rotates an image represented by NxN matrix 90 degrees
 * Can this be done in-place?
 */

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] m0 = {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24},
            {25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36},
        };
        printMatrix(m0);
        print("\n");
        printMatrix(rotateMatrix(m0));
        print("\n");
        int[][] m1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25},
        };
        printMatrix(m1);
        print("\n");
        printMatrix(rotateMatrix(m1));
        print("\n");
        int[][] m2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
        };
        printMatrix(m2);
        print("\n");
        printMatrix(rotateMatrix(m2));
        print("\n");
        int[][] m3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        printMatrix(m3);
        print("\n");
        printMatrix(rotateMatrix(m3));
        print("\n");
        int[][] m4 = {
            {1, 2},
            {3, 4}
        };
        printMatrix(m4);
        print("\n");
        printMatrix(rotateMatrix(m4));
        print("\n");
        int[][] m5 = {
            {1},
        };
        printMatrix(m5);
        print("\n");
        printMatrix(rotateMatrix(m5));

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

    public static int[][] rotateMatrix(int[][] m) {
        int n = m.length;
        int temp1, temp2;

        for (int j = 0; j <= m.length / 2; j++, n--) {
            for (int i = j; i < n - 1; i++) {
                // For r in first row, put in same position in col from back
                temp1 = m[i][n - 1];
                m[i][n - 1] = m[j][i];
                // put that temp1 in reverse position in row from bottom
                temp2 = m[n - 1][n - 1 - i + j];
                m[n - 1][n - 1 - i + j] = temp1;
                // put that temp2 in same position in col from front
                temp1 = m[n - 1 - i + j][j];
                m[n - 1 - i + j][j] = temp2;
                // put that temp1 in reverse position in row from top
                m[j][i] = temp1;
            }
        }
        return m;
    }

}
