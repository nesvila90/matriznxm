package com.quantum.matrix;

import com.quantum.matrix.cli.MatrixCli;
import com.quantum.matrix.cli.exception.GeneralException;
import com.quantum.matrix.domain.Matrix;
import com.quantum.matrix.service.exception.MatrixException;

import java.io.InputStreamReader;

/**
 * The type Matrix main.
 */
public class MatrixMain {

    /**
     * The entry point of application.
     * This method performs with the execution of arrays services
     *
     * @param args the input arguments
     * @throws MatrixException the matrix exception
     */
    public static void main(String[] args) throws MatrixException, GeneralException {

        MatrixCli cli = new MatrixCli();
        Matrix matrix = cli.execute(new InputStreamReader(System.in));
        cli.startMainDiagonalSearch(matrix);

    }

}
