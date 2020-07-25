package com.quantum.matrix.service;

import com.quantum.matrix.service.exception.MatrixException;

/**
 * The interface Matrix service.
 */
public interface MatrixService {

    /**
     * Init Matrix method
     * <p>
     * Populate the matrix from parameters n and m for rows and columns, each of one of the positions of matrix has
     * populate when the row vector position is multiplied by n parameter which is the value from the row size,
     * after, this result is summed to the current position of column vector.
     *
     * @return the int [ ] [ ]
     */
    int[][] initMatrix() throws MatrixException;


    /**
     * Populate main diagonal int [ ] with the values once you have achieved initialize the matrix.
     * This loop through the array looking for the values on the main diagonal
     *
     * @param matrix the matrix
     * @return the int [ ]
     */
    int[] populateMainDiagonal(int[][] matrix);

    /**
     * Show main diagonal loop through the string character.
     *
     * @param diagonalResult the diagonal result
     */
    void showMainDiagonal(int[] diagonalResult);

    /**
     * Display the matrix at each of its levels
     *
     * @param quadraticMatrix the quadratic matrix
     */
    void showMatrix(int[][] quadraticMatrix);
}
