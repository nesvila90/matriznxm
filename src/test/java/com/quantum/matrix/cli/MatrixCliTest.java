package com.quantum.matrix.cli;

import com.quantum.matrix.domain.Matrix;
import com.quantum.matrix.service.exception.MatrixException;
import org.junit.Test;

import java.io.InputStreamReader;

/**
 * The type Matrix cli test.
 */
public class MatrixCliTest {

    /**
     * Start main diagonal search.
     *
     * @throws MatrixException the matrix exception
     */
    @Test
    public void startMainDiagonalSearch() throws MatrixException {
        MatrixCli matrixCli = new MatrixCli();
        matrixCli.startMainDiagonalSearch(new Matrix(5, 5));

    }
}