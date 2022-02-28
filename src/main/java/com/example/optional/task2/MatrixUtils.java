package com.example.optional.task2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MatrixUtils {
    private static final int LEFT_BORDER = -23;
    public static final int RIGHT_BORDER = 23;

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int size) {
        int[][] matrix = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(LEFT_BORDER, RIGHT_BORDER);
            }
        }
        return matrix;
    }

    public static void sumBetweenFirstTwoPositiveElements(int[][] matrix) {
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
        System.out.println(sum);
    }

    public static void removeRowAndColumnWithMaxElements(int[][] matrix) {
        Set<Integer> maxElemRow = new HashSet<>();
        Set<Integer> maxElemCol = new HashSet<>();
        findPosMaxElem(matrix, maxElemCol, maxElemRow);

        int rowSize = matrix.length - maxElemRow.size();
        int colSize = matrix.length - maxElemCol.size();
        int[][] trimmedMatrix = new int[rowSize][colSize];

        for (int i = 0, rowCounter = 0; i < matrix.length; i++) {
            if (maxElemRow.contains(i)) {
                continue;
            }
            for (int j = 0, colCounter = 0; j < matrix.length; j++) {
                if (!maxElemCol.contains(j)) {
                    trimmedMatrix[rowCounter][colCounter++] = matrix[i][j];
                }
            }
            rowCounter++;
        }
        printMatrix(trimmedMatrix);
    }

    private static void findPosMaxElem(int[][] matrix, Set<Integer> maxElemCol, Set<Integer> maxElemRow) {
        int maxElem = Integer.MIN_VALUE;
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
    }
}
