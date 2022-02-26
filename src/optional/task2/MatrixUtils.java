package optional.task2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MatrixUtils {
    private static final int LEFT_BORDER = -23;
    public static final int RIGHT_BORDER = 23;

    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int size) {
        int[][] matrix = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(LEFT_BORDER, RIGHT_BORDER);
            }
        }
        return matrix;
    }

    public void task3(int[][] matrix) {
        int sum = 0;

        for (int[] row : matrix) {
            boolean foundFirstPositiveElem = false;
            int tempSum = 0;
            for (int elem : row) {
                if (elem > 0) {
                    if (foundFirstPositiveElem) {
                        sum += tempSum;
                        break;
                    }
                    foundFirstPositiveElem = true;
                } else if (foundFirstPositiveElem) {
                    tempSum += elem;
                }
            }
        }
        System.out.println("================");
        System.out.println(sum);
    }

    public void task4(int[][] matrix) {
        int maxElem = Integer.MIN_VALUE;
        Set<Integer> maxElemRow = new HashSet<>();
        Set<Integer> maxElemCol = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (maxElem <= matrix[i][j]) {
                    if (maxElem < matrix[i][j]) {
                        maxElem = matrix[i][j];
                        maxElemCol.clear();
                        maxElemRow.clear();
                    }
                    maxElemCol.add(j);
                    maxElemRow.add(i);
                }
            }
        }

        int rowSize = matrix.length - maxElemRow.size();
        int colSize = matrix.length - maxElemCol.size();
        int[][] trimmedMatrix = new int[rowSize][colSize];

        int rowCounter = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (maxElemRow.contains(i)) {
                continue;
            }
            int colCounter = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (!maxElemCol.contains(j)) {
                    trimmedMatrix[rowCounter][colCounter++] = matrix[i][j];
                }
            }
            rowCounter++;
        }
        System.out.println("=================");
        printMatrix(trimmedMatrix);
    }

}
