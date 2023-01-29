/*
 * MatrixesCalculus.java
 * Class with static methods performing basic operations on matrixes.
 * Available operations:
 * - addition
 * - subtraction
 * - multiplication
 */
public class MatrixOps {
    // generalization of the term to term operation
    private enum Operation {
        ADD, SUBTRACT, MULTIPLY
    }
    private static void checkCompatibleSize(int[][] a, int[][] b, Operation operation) {
        if (a.length != b.length || a[0].length != b[0].length) {
            String message = "Incompatible matrixes for " + operation.toString().toLowerCase() + ": " +
                    "a is " + a.length + "x" + a[0].length + " and " +
                    "b is " + b.length + "x" + b[0].length + ".";
            throw new IllegalArgumentException(message);
        }
    }
    private static int[][] performOperation(int a[][], int b[][], Operation operation) {
        System.out.print("Performing " + operation.toString().toLowerCase() + " operation... ");
        System.out.println("on matrixes of size " + a.length + "x" + a[0].length + " and " + b.length + "x" + b[0].length + ".");
        checkCompatibleSize(a, b, operation);
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
                switch (operation) {
                    case ADD:
                        result[i][j] = a[i][j] + b[i][j];
                        break;
                    case SUBTRACT:
                        result[i][j] = a[i][j] - b[i][j];
                        break;
                    case MULTIPLY:
                        result[i][j] = a[i][j] * b[i][j];
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operation.");
                }
            }
        }
        return result;
    }
    public static int[][] add(int[][] a, int[][] b) {
        return performOperation(a, b, Operation.ADD);
    }
    public static int[][] subtract(int[][] a, int[][] b) {
        return performOperation(a, b, Operation.SUBTRACT);
    }
    public static int[][] multiply(int[][] a, int[][] b) {
        return performOperation(a, b, Operation.MULTIPLY);
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * getAbsoluteSum(int[][] matrix)
     * Returns an array whose elements are the absolute sum of the rows of the matrix.
     */
    public static double[] getAbsoluteSum(int[][] matrix) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i] += Math.abs(matrix[i][j]);
            }
        }
        return result;
    }
}
