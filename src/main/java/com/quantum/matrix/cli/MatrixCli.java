package com.quantum.matrix.cli;

import com.quantum.matrix.cli.exception.GeneralException;
import com.quantum.matrix.domain.ErrorCode;
import com.quantum.matrix.domain.Matrix;
import com.quantum.matrix.service.MatrixService;
import com.quantum.matrix.service.MatrixServiceImpl;
import com.quantum.matrix.service.exception.MatrixException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The type Matrix cli.
 */
public class MatrixCli {


    /**
     * Execute cli matrix.
     *
     * @return the matrix
     */
    public Matrix execute(InputStreamReader inputStreamReader) throws GeneralException {
        int n;
        int m;

        System.out.println("################################");
        System.out.println("# Diagonal Main Look Up...     #");
        System.out.println("# Please register arrays size. #");
        System.out.println("################################ \n");

        try (BufferedReader br = new BufferedReader(inputStreamReader)) {
            System.out.println("Register the column size (Number):");
            String inputN = br.readLine();
            n = Integer.parseInt(inputN.trim());

            System.out.println("Register the row size (Number)");
            String inputM = br.readLine();
            m = Integer.parseInt(inputM.trim());

            return new Matrix(n, m);

        } catch (IOException io) {
            throw GeneralException.Builder.newBuilder().withErrorCode(ErrorCode.GENERAL_EXCEPTION)
                    .withMessage("General Error. Please Contact with the Admin.")
                    .withRootException(io)
                    .buildGeneralException();
        } catch (NumberFormatException e) {
            throw GeneralException.Builder.newBuilder().withErrorCode(ErrorCode.INCORRECT_FORMAT)
                    .withMessage("The input is incorrect.").buildGeneralException();
        }
    }

    /**
     * Start main diagonal search.
     *
     * @throws MatrixException  the matrix exception
     * @throws GeneralException the general exception
     */
    public void startMainDiagonalSearch(Matrix matrix) throws MatrixException {

        MatrixService matrixService = new MatrixServiceImpl(matrix.getN(), matrix.getM());

        int[][] quadraticMatrix = matrixService.initMatrix();
        int[] diagonalMaster = matrixService.populateMainDiagonal(quadraticMatrix);

        matrixService.showMatrix(quadraticMatrix);
        matrixService.showMainDiagonal(diagonalMaster);
    }

}
