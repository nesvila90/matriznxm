package com.quantum.matrix.service;

import com.quantum.matrix.domain.Matrix;
import com.quantum.matrix.service.exception.MatrixException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Matrix service test.
 */
public class MatrixServiceImplTest {

    private Matrix matrix;

    private int[][] expected;


    /**
     * Init before the run test.
     */
    @Before
    public void init() {

        expected = new int[][]
                {
                        {1, 6, 11, 16, 21},
                        {2, 7, 12, 17, 22},
                        {3, 8, 13, 18, 23},
                        {4, 9, 14, 19, 24},
                        {5, 10, 15, 20, 25}
                };
    }


    /**
     * Constructor matrix with null params throws matrix exception test.
     *
     * @throws MatrixException the matrix exception
     */
    @Test(expected = MatrixException.class)
    public void constructorMatrixWithNullParamsThrowsMatrixException() throws MatrixException {
        MatrixServiceImpl matrixService = new MatrixServiceImpl(null, null);
        matrixService.initMatrix();
        Assert.assertEquals("The params must be validated.", matrix.getM(), 0);
    }


    /**
     * Init matrix test.
     *
     * @throws MatrixException the matrix exception
     */
    @Test
    public void initMatrix() throws MatrixException {
        matrix = new Matrix(5, 5);
        MatrixServiceImpl matrixService = new MatrixServiceImpl(matrix.getN(), matrix.getM());
        int[][] ints = matrixService.initMatrix();
        Assert.assertArrayEquals(expected, ints);
    }

    /**
     * Init matrix when one of params is zero.
     *
     * @throws MatrixException the matrix exception
     */
    @Test(expected = MatrixException.class)
    public void initMatrixWhenOneOfParamsIsZero() throws MatrixException {
        matrix = new Matrix(5, 0);
        MatrixServiceImpl matrixService = new MatrixServiceImpl(matrix.getN(), matrix.getM());
        int[][] ints = matrixService.initMatrix();
        Assert.assertArrayEquals(expected, ints);
        Assert.assertEquals("The M param must be different of Zero.", matrix.getM(), 0);
    }

    /**
     * Init matrix when the params are different.
     *
     * @throws MatrixException the matrix exception
     */
    @Test(expected = MatrixException.class)
    public void initMatrixWhenTheParamsAreDifferent() throws MatrixException {
        matrix = new Matrix(5, 2);
        MatrixServiceImpl matrixService = new MatrixServiceImpl(matrix.getN(), matrix.getM());
        int[][] ints = matrixService.initMatrix();
        Assert.assertArrayEquals(expected, ints);
        Assert.assertEquals("The M param and N param must be equals.", matrix.getM(), matrix.getN());
    }

    /**
     * Populate main diagonal test.
     *
     * @throws MatrixException the matrix exception
     */
    @Test
    public void populateMainDiagonal() throws MatrixException {
        int[] mainDiagonalExpected = {1, 7, 13, 19, 25};
        matrix = new Matrix(5, 5);
        MatrixServiceImpl matrixService = new MatrixServiceImpl(matrix.getN(), matrix.getM());
        int[][] matrixResult = matrixService.initMatrix();
        int[] mainDiagonal = matrixService.populateMainDiagonal(matrixResult);
        Assert.assertArrayEquals(expected, matrixResult);
        Assert.assertArrayEquals(mainDiagonalExpected, mainDiagonal);
    }

    /**
     * Show main diagonal test.
     *
     * @throws MatrixException the matrix exception
     */
    @Test
    public void showMainDiagonal() throws MatrixException {
        matrix = new Matrix(5, 5);
        MatrixServiceImpl matrixService = new MatrixServiceImpl(matrix.getN(), matrix.getM());
        int[][] matrixResult = matrixService.initMatrix();
        int[] mainDiagonal = matrixService.populateMainDiagonal(matrixResult);
        matrixService.showMainDiagonal(mainDiagonal);
        Assert.assertEquals("No contente to print.", 5, mainDiagonal.length);
    }

    /**
     * Show matrix test.
     *
     * @throws MatrixException the matrix exception
     */
    @Test
    public void showMatrix() throws MatrixException {

        matrix = new Matrix(5, 5);
        MatrixServiceImpl matrixService = new MatrixServiceImpl(matrix.getN(), matrix.getM());
        int[][] matrixResult = matrixService.initMatrix();
        matrixService.showMatrix(matrixResult);
        Assert.assertEquals("No contente to print.", 5, matrixResult.length);
    }
}