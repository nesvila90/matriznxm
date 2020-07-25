package com.quantum.matrix.service;

import com.quantum.matrix.domain.ErrorCode;
import com.quantum.matrix.service.exception.MatrixException;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The type Matrix.
 */
public class MatrixServiceImpl implements MatrixService {

    private final Logger log = Logger.getLogger(MatrixServiceImpl.class.getName());

    private static final String LINE_BREAK_UP = "\n";
    private static final int START_INCLUSIVE = 0;

    private final int n;
    private final int m;

    /**
     * Instantiates a new Matrix service.
     *
     * @param n the n
     * @param m the m
     * @throws MatrixException the matrix exception
     */
    public MatrixServiceImpl(Integer n, Integer m) throws MatrixException {
        if (Objects.isNull(n) || Objects.isNull(m)) {
            throw MatrixException.Builder.newBuilder().withErrorCode(ErrorCode.DATA_CORRUPT_EXCEPTION)
                    .withMessage("The params couldn't be null.").buildMatrixException();
        }
        this.n = n;
        this.m = m;
    }


    /**
     * Init Matrix method
     * <p>
     * Populate the matrix from parameters n and m for rows and columns, each of one of the positions of matrix has
     * populate when the row vector position is multiplied by n parameter which is the value from the row size,
     * after, this result is summed to the current position of column vector.
     *
     * @return the int [ ] [ ]
     */
    public int[][] initMatrix() throws MatrixException {
        System.out.println("Init: Initialize the matrix.");
        if (n == 0 || m == 0) {
            log.log(Level.SEVERE, "The row/column params for arrays size can not be 0");
            throw MatrixException.Builder.newBuilder().withErrorCode(ErrorCode.ZERO_SIZE_PARAMETER_EXCEPTION)
                    .withMessage("The row/column size can't be 0").buildMatrixException();
        }
        if (n != m) {
            throw MatrixException.Builder.newBuilder().withErrorCode(ErrorCode.MATRIX_DIMENSION_ARE_NOT_QUADRATIC)
                    .withMessage("The row/column param must be the same").buildMatrixException();
        }

        int[][] matrix = new int[n][m];
        IntStream.range(START_INCLUSIVE, m).forEach(i -> IntStream.range(START_INCLUSIVE, n)
                .forEach(j -> matrix[j][i] = 1 + (j + n * i)));
        return matrix;
    }


    /**
     * Populate main diagonal int [ ] with the values once you have achieved initialize the matrix.
     * This loop through the array looking for the values on the main diagonal
     *
     * @param matrix the matrix
     * @return the int [ ]
     */
    public int[] populateMainDiagonal(int[][] matrix) {
        System.out.println("Init: Populate the main diagonal.");
        int[] diagonalMaster = new int[matrix.length];
        IntStream.range(START_INCLUSIVE, m).forEach(i -> IntStream.range(START_INCLUSIVE, n).filter(j -> j == i)
                .forEach(j -> diagonalMaster[j] = matrix[j][i]));
        return diagonalMaster;
    }

    /**
     * Show main diagonal loop through the string character.
     *
     * @param diagonalResult the diagonal result
     */
    public void showMainDiagonal(int[] diagonalResult) {
        System.out.println("Init: Display the Main diagonal Content.");
        Stream.of(Arrays.toString(diagonalResult)).forEach(System.out::println);
    }

    /**
     * Display the matrix at each of its levels
     *
     * @param quadraticMatrix the quadratic matrix
     */
    public void showMatrix(int[][] quadraticMatrix) {
        System.out.println("Init: Display the Matrix Content.");
        StringBuilder row = new StringBuilder();
        IntStream.range(START_INCLUSIVE, m).forEach(i -> {
            row.append(LINE_BREAK_UP);
            IntStream.range(START_INCLUSIVE, n)
                    .forEach(j -> {
                        row.append(" ");
                        row.append(quadraticMatrix[j][i]);
                    });
        });
        String result = row.toString();
        System.out.println(result);
        System.out.println("Display Finished");
    }

}
